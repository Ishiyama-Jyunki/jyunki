BEGIN;

DELETE FROM store
WHERE delete_flag = 1;

DELETE FROM product p
USING product_category pc
WHERE p.category_id = pc.category_id
  AND pc.category_name = '小説'
  AND p.store_code = 'ST008';

COMMIT;
