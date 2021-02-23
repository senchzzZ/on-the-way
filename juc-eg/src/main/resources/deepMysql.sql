-- 引擎状态
SHOW ENGINE INNODB STATUS;

-- 配置
SHOW VARIABLES;


SELECT * FROM GLOBAL_VARIABLES;

-- 缓冲池大小 默认128M
-- mysqld --innodb-buffer-pool-size=8G --innodb-buffer-pool-instances=16
SHOW VARIABLES LIKE'innodb_buffer_pool_size'；
SELECT @@innodb_buffer_pool_size/1024/1024/1024;
SELECT POOL_ID,POOL_SIZE, FREE_BUFFERS,DATABASE_PAGES FROM INNODB_BUFFER_POOL_STATS;

-- 设置缓冲池大小
SET GLOBAL innodb_buffer_pool_size=402653184;
-- 监视在线缓冲池调整大小进度
SHOW STATUS WHERE Variable_name='InnoDB_buffer_pool_resize_status';

-- 缓冲池实例个数
SHOW VARIABLES LIKE'innodb_buffer_pool_instances';
SELECT @@innodb_buffer_pool_instances;

-- 单个缓冲池大小
SHOW VARIABLES LIKE 'innodb_buffer_pool_chunk_size';
SELECT @@innodb_buffer_pool_chunk_size/1024/1024;


-- LRU midpoint位置
SHOW VARIABLES LIKE 'innodb_old_blocks_pct';
-- 页读取到 mid位置后需要等待多久才会被加入到LRU列表的热端
SHOW VARIABLES LIKE 'innodb_old_blocks_time';

-- 观察unzip_LRU列表中的页
SELECT TABLE_NAME,SPACE,PAGE_NUMBER,COMPRESSED_SIZE FROM INNODB_BUFFER_PAGE_LRU WHERE
OLDEST_MODIFICATION>0; -- 脏页
-- COMPRESSED_SIZE<>0;

-- lru列表可用页的数量
SHOW VARIABLES LIKE'innodb_lru_scan_depth';

-- 脏页达到指定占比触发agressively flush 8.x默认90
SHOW VARIABLES LIKE'innodb_max_dirty_pages_pct';
-- 脏页达到指定占比触发checkpoint刷新脏页 8.x默认10
SHOW VARIABLES LIKE 'innodb_max_dirty_pages_pct_lwm';
select @@innodb_max_dirty_pages_pct_lwm;

-- 作为每次刷新脏页的数量，最好设为每秒I/O操作数(IOPS)，默认200
show variables like 'innodb_io_capacity';
-- full purge回收的undo页数量
SHOW VARIABLES LIKE'innodb_purge_batch_size';

-- 插入缓冲-buffer选项（inserts、deletes、 purges、changes、all、none）
show variables like 'innodb_change_buffering';
-- buffer占用缓冲池内存比率
show variables like 'innodb_change_buffer_max_size';

-- 查看double write情况
SHOW GLOBAL STATUS LIKE'innodb_dblwr%';
-- 禁止double write功能
SHOW variables LIKE 'skip_innodb_doublewrite';

-- 自适应哈希索引开启状态
show variables like 'innodb_adaptive_hash_index';

-- 异步native IO开启状态
show variables like 'innodb_use_native_aio';

-- 刷新临近页
show variables like 'innodb_flush_neighbors';


-- 慢查询日志开启状态
SHOW VARIABLES LIKE 'log_slow_admin_statements';
SHOW VARIABLES LIKE 'slow_query_log%';
SET GLOBAL slow_query_log=ON;
SHOW VARIABLES LIKE 'log_queries_not_using_indexes';
SHOW VARIABLES LIKE 'long_query_time';
-- 慢查询输出格式(FILE TABLE)
SHOW VARIABLES LIKE'log_output';
select * from mysql.slow_log;
-- 每分钟允许记录到slow log的且未使用索引的SQL语句次数
show variables like 'log_throttle_queries_not_using_indexes';














