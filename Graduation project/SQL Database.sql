-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 26, 2019 at 12:20 PM
-- Server version: 10.1.39-MariaDB
-- PHP Version: 7.1.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `improve`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_info`
--

CREATE TABLE `admin_info` (
  `Username` varchar(200) NOT NULL,
  `Password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_info`
--

INSERT INTO `admin_info` (`Username`, `Password`) VALUES
('98d34c1758b15b5a359b69c2b08c5767', '10020f5c6cbe8c2eea0a18b28b37250a'),
('nasser', 'nasser'),
('nasser', 'nasser'),
('nasser', '10020f5c6cbe8c2eea0a18b28b37250a'),
('nasser', '98d34c1758b15b5a359b69c2b08c5767');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `feedback_id` int(7) NOT NULL,
  `user_id` int(7) NOT NULL,
  `feedback_txt` varchar(120) NOT NULL,
  `star` varchar(1) NOT NULL,
  `Date` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`feedback_id`, `user_id`, `feedback_txt`, `star`, `Date`) VALUES
(1, 22, 'aaaaaaaaaaaa', '4', '21-5-2019 11:14');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(7) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Mot_de_passe` varchar(30) NOT NULL,
  `Gender` varchar(6) NOT NULL,
  `Birthday_Date` varchar(11) NOT NULL,
  `IM_Join_Date` varchar(30) NOT NULL,
  `N_Apogee` int(15) NOT NULL,
  `Etat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `Name`, `Email`, `Mot_de_passe`, `Gender`, `Birthday_Date`, `IM_Join_Date`, `N_Apogee`, `Etat`) VALUES
(22, 'nasser mallouli', 'nassermallouli@gmail.com', 'nasser', 'Male', '2019-05-22', '19-5-2019 9:55', 15032353, 3),
(23, 'Ahmed mallouli', 'ahmedmallouli@gmail.com', 'nasser', 'Female', '2019-06-06', '2-6-2019 10:18', 111111111, 3),
(24, 'Sara Mallouli', 'sara@gmail.com', 'nasser', 'Female', '2019-06-19', '18-6-2019 22:6', 2147483647, 2),
(25, 'khadija wahabi', 'khadija@gmail.com', 'sanjeev', 'Female', '2019-06-21', '24-6-2019 15:54', 55555, 1);

-- --------------------------------------------------------

--
-- Table structure for table `users_notice`
--

CREATE TABLE `users_notice` (
  `notice_id` int(7) NOT NULL,
  `user_id` int(7) NOT NULL,
  `notice_txt` varchar(120) NOT NULL,
  `notice_time` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_accepts`
--

CREATE TABLE `user_accepts` (
  `user_id` int(7) NOT NULL,
  `user_accept_id` int(7) NOT NULL,
  `Date_accept` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_accepts`
--

INSERT INTO `user_accepts` (`user_id`, `user_accept_id`, `Date_accept`) VALUES
(23, 24, '2019-06-20'),
(24, 23, '2019-06-24'),
(25, 22, '2019-06-24');

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

CREATE TABLE `user_info` (
  `user_id` int(7) NOT NULL,
  `GSM` varchar(15) NOT NULL,
  `Cycle` varchar(25) NOT NULL,
  `Filiere` varchar(25) NOT NULL,
  `Niveau` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`user_id`, `GSM`, `Cycle`, `Filiere`, `Niveau`) VALUES
(22, '+212603979911', 'Master', 'CHI', 'TroisiÃ¨me annÃ©e'),
(25, '+212611111', 'Master', 'CHI', 'DeuxiÃ¨me annÃ©e');

-- --------------------------------------------------------

--
-- Table structure for table `user_post`
--

CREATE TABLE `user_post` (
  `post_id` int(7) NOT NULL,
  `user_id` int(7) NOT NULL,
  `Titre` varchar(50) NOT NULL,
  `Cycle` varchar(25) NOT NULL,
  `Filiere` varchar(25) NOT NULL,
  `Niveau` varchar(25) NOT NULL,
  `post_pdf` varchar(150) NOT NULL,
  `GSM` varchar(25) DEFAULT NULL,
  `Email` varchar(35) DEFAULT NULL,
  `post_txt` text NOT NULL,
  `post_pic` varchar(150) NOT NULL,
  `post_time` varchar(30) NOT NULL,
  `Type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_post`
--

INSERT INTO `user_post` (`post_id`, `user_id`, `Titre`, `Cycle`, `Filiere`, `Niveau`, `post_pdf`, `GSM`, `Email`, `post_txt`, `post_pic`, `post_time`, `Type`) VALUES
(37, 22, '', 'bachelier', 'CHI', 'PremiÃ¨re annÃ©e', '', '', 'nassermallouli@gmail.com', 'A ajoutÃ© une nouvelle photo.', 'Hydrangeas.jpg', ' 2019-06-02 15:12:24 ', 'Initiative'),
(39, 22, 'aaaaaaaaaaaaaaa', 'bachelier', 'CHI', '', '61059632_2215641475432762_5597019780339990528_n.jpg', '', 'nassermallouli@gmail.com', '', '1465147600germany-city.jpg', '2019-06-18 05:38:34', 'Emploi'),
(41, 22, 'aaaaaaaaaaaaaaaaa', 'bachelier', 'CHI', '', '1465147600germany-city.jpg', '', '', 'A ajoutÃ© une nouvelle photo.', 'C360_2019-06-09-20-39-14-213.jpg', '2019-06-18 06:00:55', 'Initiative'),
(42, 22, '', 'bachelier', 'CHI', '', '60869059_2355426644703121_3719065838632828928_n.jpg', '', '', 'A ajoutÃ© une nouvelle photo.', '62101496_826817497705505_19698914747744256_n.jpg', '2019-06-18 06:07:31', 'Challenges'),
(43, 22, 'Feuer Bra', 'bachelier', 'CHI', '', '', '+212603979911', 'nassermallouli@gmail.com', '', 'AlbumArt_{B5020207-474E-4720-8AFD-B100954B3B00}_Small.jpg', '2019-06-19 11:20:50', 'Talent'),
(44, 22, 'mallouli', 'Master', 'CHI', '', '', '+212603979911', 'nassermallouli@gmail.com', 'lajlmfjlmazjflmaz', 'AlbumArt_{B5020207-474E-4720-9461-7936AFA59600}_Small.jpg', '2019-06-19 15:48:47', 'Support'),
(46, 23, '', 'bachelier', 'CHI', '', '1465147600germany-city.jpg', '', '', '', '61059632_2215641475432762_5597019780339990528_n.jpg', '2019-06-24 16:45:42', 'Support');

-- --------------------------------------------------------

--
-- Table structure for table `user_post_comment`
--

CREATE TABLE `user_post_comment` (
  `comment_id` int(7) NOT NULL,
  `post_id` int(7) NOT NULL,
  `user_id` int(7) NOT NULL,
  `comment` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_post_comment`
--

INSERT INTO `user_post_comment` (`comment_id`, `post_id`, `user_id`, `comment`) VALUES
(2, 37, 23, 'malouli'),
(4, 42, 22, 'ahmed'),
(5, 44, 23, 'mallouli'),
(6, 44, 23, 'salam');

-- --------------------------------------------------------

--
-- Table structure for table `user_profile_pic`
--

CREATE TABLE `user_profile_pic` (
  `profile_id` int(7) NOT NULL,
  `user_id` int(7) NOT NULL,
  `image` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_profile_pic`
--

INSERT INTO `user_profile_pic` (`profile_id`, `user_id`, `image`) VALUES
(19, 23, '59401348_230493294580068_2733164260070261311_n.jpg'),
(20, 24, 'C360_2019-06-09-20-39-14-213.jpg'),
(25, 22, 'Koala.jpg'),
(26, 25, '61059632_2215641475432762_5597019780339990528_n.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `user_rapports`
--

CREATE TABLE `user_rapports` (
  `user_rapport_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `user_id_reported` int(11) NOT NULL,
  `rapport_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_rapports`
--

INSERT INTO `user_rapports` (`user_rapport_id`, `user_id`, `post_id`, `user_id_reported`, `rapport_date`) VALUES
(1, 24, 44, 22, '2019-06-20'),
(2, 23, 44, 22, '2019-06-24'),
(3, 22, 46, 23, '2019-06-24');

-- --------------------------------------------------------

--
-- Table structure for table `user_secret_quotes`
--

CREATE TABLE `user_secret_quotes` (
  `user_id` int(7) NOT NULL,
  `Question1` varchar(150) NOT NULL,
  `Answer1` varchar(20) NOT NULL,
  `Question2` varchar(150) NOT NULL,
  `Answer2` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_secret_quotes`
--

INSERT INTO `user_secret_quotes` (`user_id`, `Question1`, `Answer1`, `Question2`, `Answer2`) VALUES
(22, 'Quel est le nom de votre professeur de physique dans le premier cours?', 'nasser', 'Quel est ton personnage de film prÃ©fÃ©rÃ© de tous les temps?', 'nasser'),
(23, 'Quel est le nom de votre professeur de physique dans le premier cours?', 'nasser', 'Quel est le nom de votre Ã©quipe sportive prÃ©fÃ©rÃ©e?', 'nasser'),
(24, 'Quel est le lieu de votre naissance?', 'qqqqqqqqqq', 'Quel Ã©tait le nom de famille de votre premier frÃ¨re?', 'qqqqqqqq'),
(25, 'Quel est le nom de votre professeur de physique dans le premier cours?', 'nasser', 'Quel est le nom de votre Ã©quipe sportive prÃ©fÃ©rÃ©e?', 'nasser');

-- --------------------------------------------------------

--
-- Table structure for table `user_status`
--

CREATE TABLE `user_status` (
  `user_id` int(7) NOT NULL,
  `status` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`feedback_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `users_notice`
--
ALTER TABLE `users_notice`
  ADD PRIMARY KEY (`notice_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user_accepts`
--
ALTER TABLE `user_accepts`
  ADD KEY `fk_user_id` (`user_id`),
  ADD KEY `fk_user_accept_id` (`user_accept_id`);

--
-- Indexes for table `user_info`
--
ALTER TABLE `user_info`
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user_post`
--
ALTER TABLE `user_post`
  ADD PRIMARY KEY (`post_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user_post_comment`
--
ALTER TABLE `user_post_comment`
  ADD PRIMARY KEY (`comment_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `post_id` (`post_id`);

--
-- Indexes for table `user_profile_pic`
--
ALTER TABLE `user_profile_pic`
  ADD PRIMARY KEY (`profile_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user_rapports`
--
ALTER TABLE `user_rapports`
  ADD PRIMARY KEY (`user_rapport_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `post_id` (`post_id`),
  ADD KEY `user_id_reported` (`user_id_reported`);

--
-- Indexes for table `user_secret_quotes`
--
ALTER TABLE `user_secret_quotes`
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `user_status`
--
ALTER TABLE `user_status`
  ADD KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `feedback_id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `users_notice`
--
ALTER TABLE `users_notice`
  MODIFY `notice_id` int(7) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_post`
--
ALTER TABLE `user_post`
  MODIFY `post_id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `user_post_comment`
--
ALTER TABLE `user_post_comment`
  MODIFY `comment_id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user_profile_pic`
--
ALTER TABLE `user_profile_pic`
  MODIFY `profile_id` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `user_rapports`
--
ALTER TABLE `user_rapports`
  MODIFY `user_rapport_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;

--
-- Constraints for table `users_notice`
--
ALTER TABLE `users_notice`
  ADD CONSTRAINT `users_notice_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;

--
-- Constraints for table `user_accepts`
--
ALTER TABLE `user_accepts`
  ADD CONSTRAINT `fk_user_accept_id` FOREIGN KEY (`user_accept_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;

--
-- Constraints for table `user_info`
--
ALTER TABLE `user_info`
  ADD CONSTRAINT `user_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;

--
-- Constraints for table `user_post`
--
ALTER TABLE `user_post`
  ADD CONSTRAINT `user_post_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;

--
-- Constraints for table `user_post_comment`
--
ALTER TABLE `user_post_comment`
  ADD CONSTRAINT `user_post_comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `user_post_comment_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `user_post` (`post_id`) ON DELETE CASCADE;

--
-- Constraints for table `user_profile_pic`
--
ALTER TABLE `user_profile_pic`
  ADD CONSTRAINT `user_profile_pic_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;

--
-- Constraints for table `user_rapports`
--
ALTER TABLE `user_rapports`
  ADD CONSTRAINT `rapport_post_id` FOREIGN KEY (`post_id`) REFERENCES `user_post` (`post_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `rapport_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;

--
-- Constraints for table `user_secret_quotes`
--
ALTER TABLE `user_secret_quotes`
  ADD CONSTRAINT `user_secret_quotes_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;

--
-- Constraints for table `user_status`
--
ALTER TABLE `user_status`
  ADD CONSTRAINT `user_status_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `user_status_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
