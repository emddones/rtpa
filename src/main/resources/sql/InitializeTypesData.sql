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