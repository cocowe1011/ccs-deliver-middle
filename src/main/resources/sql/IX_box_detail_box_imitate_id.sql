-- 按箱号删除/查询箱明细，避免全表扫描触发锁升级阻塞整批保存
IF NOT EXISTS (
    SELECT 1
    FROM sys.indexes
    WHERE name = 'IX_box_detail_box_imitate_id'
      AND object_id = OBJECT_ID('dbo.box_detail')
)
CREATE NONCLUSTERED INDEX IX_box_detail_box_imitate_id
ON dbo.box_detail (box_imitate_id);