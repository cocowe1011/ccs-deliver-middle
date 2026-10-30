-- 按当天模拟箱号前缀取最大序号，以及按箱号查询已有箱子
IF NOT EXISTS (
    SELECT 1
    FROM sys.indexes
    WHERE name = 'IX_box_main_box_imitate_id'
      AND object_id = OBJECT_ID('dbo.box_main')
)
CREATE NONCLUSTERED INDEX IX_box_main_box_imitate_id
ON dbo.box_main (box_imitate_id);
