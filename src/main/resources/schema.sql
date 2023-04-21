-- create table bible_verse
-- (
--     idx         bigint auto_increment
--         primary key,
--     book        int          null,
--     cate        int          null,
--     chapter     int          null,
--     long_label  varchar(255) null,
--     paragraph   int          null,
--     sentence    text         null,
--     short_label varchar(255) null,
--     testament   varchar(255) null
-- );

CREATE TABLE IF NOT EXISTS `bible_verse` (
  `idx` int(11) NOT NULL AUTO_INCREMENT,
  `cate` int(11) NOT NULL,
  `book` int(11) NOT NULL,
  `chapter` int(11) NOT NULL,
  `paragraph` int(11) NOT NULL,
  `sentence` tinytext NOT NULL,
  `testament` varchar(10) NOT NULL,
  `long_label` varchar(30) NOT NULL,
  `short_label` varchar(10) NOT NULL,
  PRIMARY KEY (`idx`),
  KEY `idx_sequence` (`book`,`chapter`,`paragraph`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=31139 ;