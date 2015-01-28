--
-- Database: `equipment_db`
--
USE `equipment_db`;

--
-- Dumping data for table `equipment_information`
--

INSERT INTO `equipment_information` (`pkey`, `barcode`, `equipment_type_fk`, `room`, `serial_number`, `manufacturer_fk`, `model_number`, `begin_service_date`, `cost`, `age`) VALUES
(5643, 'D03910', 43, 'BS', '6901646', 1, '73402', '1997-08-13 00:00:00', 3200, 17),
(5644, 'D41217', 44, 'BS', '137967', 2, 'CW50', '1999-03-31 00:00:00', 370, 15),
(5645, 'D63199', 45, 'BS', '1000608714', 3, '8HP', '2000-10-30 00:00:00', 573, 14),
(5646, 'D63228', 46, 'BS', '8621', 4, 'M1600', '2000-10-30 00:00:00', 673, 14),
(5647, 'D78985', 46, 'BS', 'R75356AF891', 5, 'HOLT', '2003-11-10 00:00:00', 750, 11),
(5648, 'D78986', 44, 'BS', '099800029751', 6, 'NA', '2003-11-10 00:00:00', 500, 11),
(5649, 'D82758', 47, 'BS', '12799', 7, '415S', '2001-11-06 00:00:00', 300, 13),
(5650, 'D82759', 44, 'BS', '189858', 2, 'CW50', '2001-11-06 00:00:00', 412, 13),
(5651, 'E07934', 48, 'BS', '240001964', 1, '38620', '2003-08-22 00:00:00', 892, 11),
(5652, 'E11620', 44, 'BS', '198651', 2, 'CW50', '2003-07-01 00:00:00', 412, 11),
(5653, 'E11731', 49, 'BS', 'N364', 4, 'M1600', '2003-08-11 00:00:00', 673, 11),
(5654, 'E27045', 48, 'BS', '9002305', 1, '38052', '1989-12-20 00:00:00', 720, 25),
(5655, 'E27046', 46, 'BS', '8930558', 5, 'LR13758', '2003-08-21 00:00:00', 673, 11),
(5656, 'E27047', 47, 'BS', 'P2305', 8, 'NA', '2003-08-21 00:00:00', 299, 11),
(5657, 'E27068', 50, 'BS', '21149313', 9, 'SCM1282', '2003-08-21 00:00:00', 327, 11);

--
-- Dumping data for table `equipment_type`
--

INSERT INTO `equipment_type` (`pkey`, `equipment_id`, `description`, `rank`, `replacement_cost`) VALUES
(43, NULL, 'BLDSERV-TRACTOR', NULL, NULL),
(44, NULL, 'BLDSERV-CLEANER VAC UP/R', NULL, NULL),
(45, NULL, 'BLDSERV-BLOWER LEAF', NULL, NULL),
(46, NULL, 'BLDSERV-BUFFER/POLISHER', NULL, NULL),
(47, NULL, 'BLDSERV-CLEANER VAC W/D', NULL, NULL),
(48, NULL, 'BLDSERV-SNOW BLOWER', NULL, NULL),
(49, NULL, 'BLDSERV-BURNISHER', NULL, NULL),
(50, NULL, 'BLDSERV-CLEANER VAC STRAP', NULL, NULL),
(51, NULL, 'BLDSERV-SCRUBBER', NULL, NULL),
(52, NULL, 'BLDSERV-WEED EATER', NULL, NULL),
(53, NULL, 'BLDSERV-TRIM HEDGE', NULL, NULL),
(54, NULL, 'BLDSERV-LAWN MOWER', NULL, NULL),
(55, NULL, 'BLDSERV-EXTRACTOR/SHAMPOO', NULL, NULL),
(56, NULL, 'BLDSERV-EDGER', NULL, NULL),
(57, NULL, 'BLDSERV-PRESSURE WASHER', NULL, NULL),
(58, NULL, 'BLDSERV-CHAIN SAW', NULL, NULL),
(59, NULL, 'BLDSERV-LIFT', NULL, NULL),
(60, NULL, 'BLDSERV-MACHINE SCRUBBER', NULL, NULL),
(61, NULL, 'BLDSERV-TRIMMER LAWN', NULL, NULL),
(62, NULL, 'BLDSERV-MISC/OTHER', NULL, NULL),
(63, NULL, 'BLDSERV-MACHINE FLOOR', NULL, NULL),
(64, NULL, 'BLDSERV-VACUUM WALK-BEHIND', NULL, NULL),
(65, NULL, 'CAF-TABLE WORK', NULL, NULL),
(66, NULL, 'BLDSERV-MANUAL JACK', NULL, NULL),
(67, NULL, 'BLDSERV-EDGER STICK', NULL, NULL),
(68, NULL, 'BLDSERV-OTHER', NULL, NULL),
(69, NULL, 'BLDSERV-SCRUBBER wall', NULL, NULL),
(70, NULL, 'BLDSERV-01', NULL, NULL),
(71, NULL, 'BLDSERV-AIR COMPRE', NULL, NULL),
(72, NULL, 'BLDSERV-LAWN MOWER - PUSH', NULL, NULL),
(73, NULL, 'BLDSERV-PLATFORM', NULL, NULL),
(74, NULL, 'CAF-MIXER 40  QUART', NULL, NULL),
(75, NULL, 'BLDSERV-CHAINSAW', NULL, NULL),
(76, NULL, 'BLDSERV-SCRUBBER WALL', NULL, NULL),
(77, NULL, 'BLDSERV-PALLET JACK', NULL, NULL),
(78, NULL, 'BLDSERV-MACHINE', NULL, NULL),
(79, NULL, 'BLDSERV-LAWNMOWER', NULL, NULL),
(80, NULL, 'BLDSERV-CHIPPER VAC', NULL, NULL),
(81, NULL, 'IND-WELDER ARC', NULL, NULL),
(82, NULL, 'BLDSERV-VAC UP/R', NULL, NULL),
(83, NULL, 'IND-CHAIN SAW', NULL, NULL),
(84, NULL, 'IND-OTHER', NULL, NULL);

--
-- Dumping data for table `manufacturer`
--

INSERT INTO `manufacturer` (`pkey`, `name`) VALUES
(1, 'TORO'),
(2, 'KARCHER'),
(3, 'LITTLE WONDER'),
(4, 'POWERFLITE'),
(5, 'PULL/HOLT'),
(6, 'HOOVER'),
(7, 'EAGLE'),
(8, 'MASTERCRAFT'),
(9, 'PROTEAM'),
(10, 'NOBLES'),
(11, 'DART'),
(12, 'RAVEN'),
(13, 'ECHO'),
(14, 'HONDA'),
(15, 'TENNANT'),
(16, 'TORNADO'),
(17, 'SENSOR'),
(18, 'PRO TEAM'),
(19, 'EXMARK'),
(20, 'MERCURY'),
(21, 'ENVIROCLEAN'),
(22, 'POWER-FLITE'),
(23, 'GENERAL'),
(24, 'CUB CADET'),
(25, 'MINUTEMAN'),
(26, 'KRANZLE'),
(27, 'HAWK'),
(28, 'TOPVAC'),
(29, 'KUBOTA'),
(30, 'KENT'),
(31, 'WINDSOR'),
(32, 'VIKING'),
(33, 'COLEMAN'),
(34, 'MEHO'),
(35, 'MONGOOSE'),
(36, 'GENIE'),
(37, 'CONCORD'),
(38, 'PRO MOW GOLD'),
(39, 'JDEERE'),
(40, 'BRIGGS'),
(41, 'LITTLEWONDER'),
(42, 'KRANZEL'),
(43, 'BURTON'),
(44, 'SHOP-VAC'),
(45, 'WHEEL HORSE'),
(46, 'JLG'),
(47, 'CUSTEQ'),
(48, 'SIMPLI'),
(49, 'ADVANCE'),
(50, 'POWERFLIGHT'),
(51, 'NA'),
(52, 'TASKFORCE'),
(53, 'BOBCAT'),
(54, 'POULAN-PRO'),
(55, 'CASTEX'),
(56, 'JACOBSEN'),
(57, 'PERFECT'),
(58, 'SUPER'),
(59, 'SUPER COACH'),
(60, 'VIPER'),
(61, 'DEERE'),
(62, 'STEAMEX'),
(63, 'General'),
(64, 'REMINGTON'),
(65, 'CRAFTSMAN'),
(66, 'SHOPVAC'),
(67, 'RIDGID'),
(68, ' ECHO'),
(69, 'ADVOLUTION'),
(70, 'MELANE'),
(71, 'WHEELHORSE'),
(72, 'QUANTUM'),
(73, 'PULLMAN HOLT'),
(74, 'HEPAVAC'),
(75, 'YARD'),
(76, 'POWER FLITE'),
(77, 'COLT'),
(78, 'DURA'),
(79, 'MASTER'),
(80, 'WONDER'),
(81, 'DAYTON'),
(82, 'FORD'),
(83, 'EXCALIBUR'),
(84, 'Tennant'),
(85, 'TENANT'),
(86, 'BillyGOAT'),
(87, 'CROWN'),
(88, 'PROGUARD'),
(89, 'AMFAB'),
(90, 'DURABUI14'),
(91, 'BILLY GOAT'),
(92, 'EASY REACH'),
(93, 'MASTER CRAFT'),
(94, 'POWR-FLITE'),
(95, 'DIRT KILLER'),
(96, 'METRO'),
(97, 'M/CRFT'),
(98, 'KENT/HOLT'),
(99, 'BILLYGOAT'),
(100, 'CUB'),
(101, 'ELKYPRO'),
(102, 'PULLMAN/HOLT'),
(103, 'DIRTKILLER'),
(104, 'B&S'),
(105, 'SPACE SHUTTLE'),
(106, 'HOMELITE'),
(107, 'TWIN'),
(108, 'US FLOOR'),
(109, 'BRIGGS & STRATTON'),
(110, 'BX'),
(111, 'WHHORS'),
(112, 'TROYBUILT'),
(113, 'HAKO'),
(114, 'E2ROLL'),
(115, 'ENVIRO CLEAN'),
(116, 'TASK FORCE'),
(117, 'NOBLE'),
(118, 'SIMPSON'),
(119, 'WHIRLMATIC'),
(120, 'TROY-BILT'),
(121, 'POWERFLITE1'),
(122, 'TROY/MTD'),
(123, 'EAGLE POWER'),
(124, 'HUSQVARNA'),
(125, 'TORE/WHEELHORSE'),
(126, 'TRUW'),
(127, 'MINUTIMAN'),
(128, 'VIPERSLIDER'),
(129, 'US'),
(130, 'SANITAIRE'),
(131, 'WIND'),
(132, 'CLARKE'),
(133, 'BIILYGOAT'),
(134, 'MASTERCUT'),
(135, 'SCAFFOLDING DEPOT'),
(136, 'CLARK'),
(137, 'STIHL'),
(138, 'CRAFTMANS'),
(139, 'SANDIA'),
(140, 'KAWASAKI'),
(141, 'wINDSOR'),
(142, 'ELECTRIC'),
(143, 'EXCELL'),
(144, 'SHOP VAC'),
(145, 'TOP VAC'),
(146, 'AMERICAN CLEAN'),
(147, 'HOLTON'),
(148, 'TASTFORCE'),
(149, 'SUPERCOACH'),
(150, 'HORIZON'),
(151, 'SRUBBER'),
(152, 'SPACE'),
(153, 'PACIFIC'),
(154, 'CYCLONE RAKE'),
(155, 'DEWALT'),
(156, 'GATOR'),
(157, 'MINUTEMEN'),
(158, 'FAST'),
(159, 'BOB CAT'),
(160, 'CAPP'),
(161, 'POWER EASE'),
(162, 'CLEAN TRONIC'),
(163, 'DEERE GATOR'),
(164, 'NATION'),
(165, 'MTD'),
(166, 'RUG DOCTOR'),
(167, 'JOHN DEERE'),
(168, 'WEED EATER'),
(169, 'TRUEHEPA'),
(170, 'LAWNBOY'),
(171, 'WINSOR'),
(172, 'POWER FLIGHT'),
(173, 'RED'),
(174, 'HALCO'),
(175, 'HECHINGER'),
(176, 'PULLMAN'),
(177, 'PULMAN'),
(178, 'UPRIGHT'),
(179, 'TENNENT'),
(180, 'SS'),
(181, 'HOBART'),
(182, 'TORADO'),
(183, 'NUMATIC'),
(184, 'GIANT'),
(185, 'ROTARY'),
(186, 'NILFISK'),
(187, 'KURSWEIL'),
(188, 'HIPHUGGER'),
(189, 'EMBASSADOR'),
(190, 'HOMELIGHT'),
(191, 'KOHLER'),
(192, 'COACH'),
(193, 'EXMARK11'),
(194, 'MC LANE'),
(195, 'Windsor'),
(196, 'SPEEDLEAH'),
(197, 'HUSKY'),
(198, 'BOLENS'),
(199, 'TEXTRON'),
(200, 'CFR'),
(201, 'HERCULES'),
(202, 'HUSQ'),
(203, 'POWER EAGLE'),
(204, 'LEXMARK'),
(205, 'CASTEX EAGLE'),
(206, 'PERECT'),
(207, 'CASE'),
(208, 'RIGED'),
(209, 'UNISOURCE'),
(210, 'XMARK'),
(211, 'SNAP-ON'),
(212, 'MILWAUKEE'),
(213, 'NORTHSTAR'),
(214, 'SANITARE'),
(215, 'GE'),
(216, 'SANDIA-RAVEN'),
(217, 'PERFECT VAC'),
(218, 'SP 21'),
(219, 'MINMAN'),
(220, 'BURNIS'),
(221, 'BAILEY'),
(222, 'RYOBI'),
(223, 'KD5'),
(224, 'DOERR'),
(225, 'PROEAGLE'),
(226, 'COMMERICAL'),
(227, 'KANZLE'),
(228, 'RANSOMES'),
(229, 'JACOBSON'),
(230, 'HOMELYTE'),
(231, 'CRATTSMAN'),
(232, 'ARIENS'),
(233, 'CAMPBELL'),
(234, 'ECH0'),
(235, 'MCLANE'),
(236, 'YARDMAN'),
(237, 'DANZIG'),
(238, 'GAS'),
(239, 'YARD MACHINE'),
(240, 'PULLMANHOLT'),
(241, 'WORLD'),
(242, 'SPEED'),
(243, 'ADMIRAL'),
(244, 'NSS'),
(245, 'EXMARK1'),
(246, 'TENNETT'),
(247, 'gaithersburg equipment co'),
(248, 'SCHO'),
(249, 'JLG  LIFT'),
(250, 'EXXMARK'),
(251, 'BS'),
(252, 'CLEAN'),
(253, 'US  14'),
(254, 'BRIGGS AND STATTON'),
(255, 'SIMPLICITY'),
(256, 'STEAMX'),
(257, 'CUB CADEET'),
(258, 'TROY BILT'),
(259, 'BLACK&DECKER'),
(260, 'I-H'),
(261, 'SSS'),
(262, 'ADRIENS'),
(263, 'power'),
(264, 'Capital Compressor Inc'),
(265, 'MILLER'),
(266, 'TKLOAD'),
(267, 'LAZER'),
(268, 'LAZER Z'),
(269, 'NEW HOLLAND'),
(270, 'BRADCO'),
(271, 'ALKOTA'),
(272, 'HARVST'),
(273, 'GERERAL');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;