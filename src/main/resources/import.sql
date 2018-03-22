TRUNCATE TABLE t_attribute_type;
TRUNCATE TABLE t_source_type;
TRUNCATE TABLE t_error_type;

INSERT INTO t_source_type (`code`, `is_reference_source`) VALUES ('QRS', 1);
INSERT INTO t_source_type (`code`, `is_reference_source`) VALUES ('ESL', 0);
INSERT INTO t_source_type (`code`, `is_reference_source`) VALUES ('SM', 0);
INSERT INTO t_source_type (`code`, `is_reference_source`) VALUES ('VM', 0);

INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('QRS.DN', 'Domain Name', 'Domain Name', NULL, 80, 'QRS');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('QRS.RAM', 'RAM Module installed', 'Memory', NULL, 80, 'QRS');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('QRS.PROCESSOR', 'Number of Processor Cores and Type', 'Processor', NULL, 80, 'QRS');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('QRS.STORAGE', 'Physical Storage Capacity', 'Storage', NULL, 80, 'QRS');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('QRS.OS', 'Operating System Installed (Linux, Windows)', 'OS', NULL, 80, 'QRS');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('QRS.NIC', 'Number of Network Interface Card installed', 'NIC', NULL, 80, 'QRS');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('ESL.DN', 'Domain Name', 'Domain Name', NULL, 80, 'ESL');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('ESL.RAM', 'RAM Module installed', 'Memory', NULL, 80, 'ESL');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('ESL.PROCESSOR', 'Number of Processor Cores and Type', 'Processor', NULL, 80, 'ESL');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('ESL.STORAGE', 'Physical Storage Capacity', 'Storage', NULL, 80, 'ESL');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('ESL.OS', 'Operating System Installed (Linux, Windows)', 'OS', NULL, 80, 'ESL');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('ESL.NIC', 'Number of Network Interface Card installed', 'NIC', NULL, 80, 'ESL');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('SM.DN', 'Domain Name', 'Domain Name', NULL, 80, 'SM');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('SM.RAM', 'RAM Module installed', 'Memory', NULL, 80, 'SM');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('SM.PROCESSOR', 'Number of Processor Cores and Type', 'Processor', NULL, 80, 'SM');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('SM.STORAGE', 'Physical Storage Capacity', 'Storage', NULL, 80, 'SM');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('SM.OS', 'Operating System Installed (Linux, Windows)', 'OS', NULL, 80, 'SM');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('SM.NIC', 'Number of Network Interface Card installed', 'NIC', NULL, 80, 'SM');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('VM.DN', 'Domain Name', 'Domain Name', NULL, 80, 'VM');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('VM.RAM', 'RAM Module installed', 'Memory', NULL, 80, 'VM');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('VM.PROCESSOR', 'Number of Processor Cores and Type', 'Processor', NULL, 80, 'VM');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('VM.STORAGE', 'Physical Storage Capacity', 'Storage', NULL, 80, 'VM');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('VM.OS', 'Operating System Installed (Linux, Windows)', 'OS', NULL, 80, 'VM');
INSERT INTO t_attribute_type (`code`, `description`, `label`, `prec`, `size`, `source_type_code`) VALUES ('VM.NIC', 'Number of Network Interface Card installed', 'NIC', NULL, 80, 'VM');

INSERT INTO `t_error_type` (`code`, `message`) VALUES ('1027', 'Set RAM is lower than expected');
INSERT INTO `t_error_type` (`code`, `message`) VALUES ('1018', 'Set Storage is higher than requested');
INSERT INTO `t_error_type` (`code`, `message`) VALUES ('1028', 'Set RAM is higher than expected');

COMMIT;

TRUNCATE TABLE t_attribute;
TRUNCATE TABLE t_source;
TRUNCATE TABLE t_request;

INSERT INTO `t_request` (`code`) VALUES ('QRS-US-001');
INSERT INTO `t_request` (`code`) VALUES ('QRS-US-002');

INSERT INTO `t_source` (`id`, `run_date`, `run_number`, `request_code`, `source_type_code`) VALUES ('1001', '2018-01-31 03:00:00', '1', 'QRS-US-001', 'QRS');
INSERT INTO `t_source` (`id`, `run_date`, `run_number`, `request_code`, `source_type_code`) VALUES ('1002', '2018-01-31 03:00:00', '1', 'QRS-US-001', 'ESL');
INSERT INTO `t_source` (`id`, `run_date`, `run_number`, `request_code`, `source_type_code`) VALUES ('1003', '2018-01-31 03:00:00', '1', 'QRS-US-001', 'SM');
INSERT INTO `t_source` (`id`, `run_date`, `run_number`, `request_code`, `source_type_code`) VALUES ('1004', '2018-01-31 03:00:00', '1', 'QRS-US-001', 'VM');

INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1001001,1,'ok','US-001-SM1','',1001,'QRS.DN');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1001002,1,'ok','2 GB','',1001,'QRS.RAM');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1001003,1,'ok','4 (M) Cores','',1001,'QRS.PROCESSOR');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1001004,1,'ok','40 GB','',1001,'QRS.STORAGE');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1001005,1,'ok','RHEL 12.0','',1001,'QRS.OS');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1001006,1,'ok','2','',1001,'QRS.NIC');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1002001,1,'ok','US-001-SM1','',1002,'ESL.DN');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1002002,1,'nok','1 GB','1027',1002,'ESL.RAM');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1002003,1,'ok','4 (M) Cores','',1002,'ESL.PROCESSOR');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1002004,1,'nok','80 GB','1018',1002,'ESL.STORAGE');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1002005,1,'ok','RHEL 12.0','',1002,'ESL.OS');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1002006,1,'ok','2','',1002,'ESL.NIC');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1003001,1,'ok','US-001-SM1','',1003,'SM.DN');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1003002,1,'ok','2 GB','',1003,'SM.RAM');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1003003,1,'ok','4 (M) Cores','',1003,'SM.PROCESSOR');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1003004,1,'ok','40 GB','',1003,'SM.STORAGE');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1003005,1,'ok','RHEL 12.0','',1003,'SM.OS');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1003006,1,'ok','2','',1003,'SM.NIC');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1004001,1,'ok','US-001-SM1','',1004,'VM.DN');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1004002,1,'nok','4 GB','1028',1004,'VM.RAM');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1004003,1,'ok','4 (M) Cores','',1004,'VM.PROCESSOR');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1004004,1,'ok','40 GB','',1004,'VM.STORAGE');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1004005,1,'ok','RHEL 12.0','',1004,'VM.OS');
INSERT INTO `t_attribute` (`id`,`seq_no`,`status`,`value`,`error_type_code`,`source_id`,`attribute_type_code`) VALUES (1004006,1,'ok','2','',1004,'VM.NIC');


COMMIT;