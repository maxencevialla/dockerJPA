ALTER TABLE CHARACTER_ITEM DROP CONSTRAINT FK_CHARACTER_ITEM_items_ID
ALTER TABLE CHARACTER_ITEM DROP CONSTRAINT FK_CHARACTER_ITEM_Character_ID
DROP TABLE CHARACTER
DROP TABLE ITEM
DROP TABLE CHARACTER_ITEM
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'