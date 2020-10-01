USE papyrus;

DROP TABLE if EXISTS ARTICLES_A_COMMANDER;

CREATE TABLE articles_a_commander (
  codart char(4) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  qte int(11) NOT NULL,
  PRIMARY KEY (codart, `date`),
  FOREIGN KEY (codart) REFERENCES produit (codart)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TRIGGER if EXISTS after_update_articles_a_commander;

delimiter |

CREATE TRIGGER after_update_articles_a_commander
AFTER UPDATE ON produit
	FOR EACH ROW 
	BEGIN
		DECLARE stk_phy INT;
		DECLARE stk_alert INT;
		DECLARE quantite_a_commander INT;
		DECLARE maj_qtite_a_commander INT;
		
		SET @stk_phy = (SELECT stkphy FROM produit WHERE codart = new.codart);
		SET @stk_alert = (SELECT stkale FROM produit WHERE codart = new.codart); 
		SET @quantite_a_commander = ((SELECT stkale FROM produit WHERE codart = new.codart) - (SELECT stkphy FROM produit WHERE codart = new.codart));
			
		if (SELECT COUNT(codart) FROM articles_a_commander WHERE codart = new.codart) > 0 
		then
			SET @maj_qtite_a_commander = (@quantite_a_commander - (SELECT SUM(QTE) FROM articles_a_commander WHERE codart = new.codart));
		ELSE
			SET @maj_qtite_a_commander = @quantite_a_commander;
		END if;
		
		if @stk_alert > @stk_phy 
		then 
			INSERT INTO articles_a_commander(codart, qte) VALUES (new.codart, @maj_quantite_a_commander);
		END if;
END |

delimiter ; 

/* on test notre trigger */

UPDATE produit SET stkphy = 9 WHERE codart = 'I110';
UPDATE produit SET stkphy = 7 WHERE codart = 'I110';

-- VERIFICATION INSERTION
UPDATE produit SET stkphy = 10 WHERE `codart` = 'B001';
-- VERIFICATION CALCUL
UPDATE produit SET stkphy = 10 WHERE `codart` = 'B001';
