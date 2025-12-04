BEGIN;

UPDATE store
SET delete_flag = 1,
updated_at  = CURRENT_TIMESTAMP
WHERE store_code = 'ST028';

UPDATE product
SET product_price = 1500,
updated_at  = CURRENT_TIMESTAMP
WHERE product_name = '新鮮野菜セット';

UPDATE product p
SET stock_quantity = 50,
updated_at  = CURRENT_TIMESTAMP
FROM product_category pc
WHERE p.category_id = pc.category_id
AND pc.category_name = 'お菓子'
AND p.store_code = 'ST013';

COMMIT;



