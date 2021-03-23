-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 23, 2021 at 05:14 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `techproject_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `courseid` int(11) NOT NULL,
  `coursename` varchar(50) NOT NULL,
  `coursetype` varchar(30) NOT NULL,
  `courseprice` double NOT NULL,
  `orderstatus` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`courseid`, `coursename`, `coursetype`, `courseprice`, `orderstatus`) VALUES
(1, 'Trignometry', 'Math', 2500, 0),
(2, 'Biology', 'Science', 3000, 1),
(3, 'Hacking', 'ICT', 4100, 1),
(4, 'ABC', '114', 4545, 1);

-- --------------------------------------------------------

--
-- Table structure for table `imagelocation`
--

CREATE TABLE `imagelocation` (
  `imgid` int(11) NOT NULL,
  `img_Path` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `imagelocation`
--

INSERT INTO `imagelocation` (`imgid`, `img_Path`) VALUES
(1, 'E:\\Complete Spring Tech Project\\imgLocation\\1 Hidden.jpg'),
(2, 'E:\\Complete Spring Tech Project\\imgLocation\\2 Law.jpg'),
(3, 'E:\\Complete Spring Tech Project\\imgLocation\\3 Nickel boys.png');

-- --------------------------------------------------------

--
-- Table structure for table `usercoursedetails`
--

CREATE TABLE `usercoursedetails` (
  `urscrsid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `courseid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usercoursedetails`
--

INSERT INTO `usercoursedetails` (`urscrsid`, `userid`, `courseid`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 1, 3),
(4, 1, 2),
(5, 3, 1),
(6, 3, 3),
(7, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userid` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `mobileno` varchar(12) NOT NULL,
  `email` varchar(35) NOT NULL,
  `usertype` varchar(15) NOT NULL,
  `password` varchar(100) NOT NULL,
  `loginstatus` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userid`, `username`, `mobileno`, `email`, `usertype`, `password`, `loginstatus`) VALUES
(1, 'ARUN', '0774567895', 'admin@g.com', 'Student', '', 1),
(2, 'muja', '075456565', 'asd@gamil.com', 'student', '', 1),
(3, 'REDDY', '7894858965', 'string@g.com', 'Student', '', 1),
(4, 'WRSATR', '789456858', 'sadwrd@g.com', 'Student', '', 1),
(5, 'admin', '456785698', 'admin@g.com', 'ADMIN', '123', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`courseid`);

--
-- Indexes for table `imagelocation`
--
ALTER TABLE `imagelocation`
  ADD PRIMARY KEY (`imgid`);

--
-- Indexes for table `usercoursedetails`
--
ALTER TABLE `usercoursedetails`
  ADD PRIMARY KEY (`urscrsid`),
  ADD KEY `userid` (`userid`),
  ADD KEY `courseid` (`courseid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `imagelocation`
--
ALTER TABLE `imagelocation`
  MODIFY `imgid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `usercoursedetails`
--
ALTER TABLE `usercoursedetails`
  MODIFY `urscrsid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `usercoursedetails`
--
ALTER TABLE `usercoursedetails`
  ADD CONSTRAINT `usercoursedetails_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`),
  ADD CONSTRAINT `usercoursedetails_ibfk_2` FOREIGN KEY (`courseid`) REFERENCES `course` (`courseid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
