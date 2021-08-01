-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 21, 2019 at 08:09 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tiketpesawat`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` varchar(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` text NOT NULL,
  `phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `address`, `phone`) VALUES
('P001', 'Aldhi Ramdan', 'Bekasi', '081283913671'),
('P002', 'Adi', 'Depok', '08128293746');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` varchar(10) NOT NULL,
  `name` varchar(40) NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `address`, `phone`) VALUES
('K001', 'Didin Rustadin', 'Mampang Prapatan', '0899873632');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `id` varchar(10) NOT NULL,
  `book_date` varchar(20) NOT NULL,
  `cust_id` varchar(10) NOT NULL,
  `cust_name` varchar(40) NOT NULL,
  `cust_address` text NOT NULL,
  `cust_phone` varchar(20) NOT NULL,
  `tiket_id` varchar(10) NOT NULL,
  `tiket_maskapai` varchar(20) NOT NULL,
  `tiket_class` varchar(20) NOT NULL,
  `tiket_destination` varchar(30) NOT NULL,
  `tiket_price` decimal(30,0) NOT NULL,
  `tiket_status` varchar(20) NOT NULL,
  `jumlah` int(10) NOT NULL,
  `total` decimal(20,0) NOT NULL,
  `jml_bayar` decimal(20,0) NOT NULL,
  `create_at` date NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'berhasil'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`id`, `book_date`, `cust_id`, `cust_name`, `cust_address`, `cust_phone`, `tiket_id`, `tiket_maskapai`, `tiket_class`, `tiket_destination`, `tiket_price`, `tiket_status`, `jumlah`, `total`, `jml_bayar`, `create_at`, `status`) VALUES
('B001', '2019-05-18', 'P001', 'Aldhi Ramdan', 'Jatiasih, Bekasi', '081283913671', 'T001', 'Air Asia', 'Ekonomi', 'JAKARTA - YOGYAKARTA', '300000', 'Tidak Tersedia', 2, '600000', '0', '2019-05-18', 'dibatalkan'),
('B002', '2019-05-18', 'P001', 'Aldhi Ramdan', 'Jatiasih, Bekasi', '081283913671', 'T001', 'Air Asia', 'Ekonomi', 'JAKARTA - YOGYAKARTA', '300000', 'Tidak Tersedia', 2, '600000', '0', '2019-05-18', 'berhasil'),
('B003', '2019-05-18', 'P001', 'Aldhi Ramdan', 'Jatiasih, Bekasi', '081283913671', 'T001', 'Air Asia', 'Ekonomi', 'JAKARTA - YOGYAKARTA', '300000', 'Tidak Tersedia', 1, '300000', '0', '2019-05-18', 'berhasil'),
('B004', '2019-05-18', 'P002', 'Adi', 'Depok', '08128293746', 'T002', 'Lion Air', 'Eksekutif', 'JAKARTA-BALI', '1900000', 'Tersedia', 2, '3800000', '0', '2019-05-18', 'berhasil'),
('B005', '2019-05-18', 'P002', 'Adi', 'Depok', '08128293746', 'T001', 'Air Asia', 'Ekonomi', 'JAKARTA - YOGYAKARTA', '300000', 'Tidak Tersedia', 1, '300000', '0', '2019-05-18', 'berhasil'),
('B006', '2019-05-19', 'P001', 'Aldhi Ramdan', 'Bekasi', '081283913671', 'T002', 'Lion Air', 'Eksekutif', 'JAKARTA-BALI', '1900000', 'Tersedia', 1, '1900000', '1900000', '2019-05-19', 'berhasil'),
('B007', '2019-05-19', 'P001', 'Aldhi Ramdan', 'Bekasi', '081283913671', 'T001', 'Air Asia', 'Ekonomi', 'JAKARTA - YOGYAKARTA', '300000', 'Tidak Tersedia', 1, '300000', '600000', '2019-05-19', 'berhasil'),
('B007', '2019-05-19', 'P001', 'Aldhi Ramdan', 'Bekasi', '081283913671', 'T001', 'Air Asia', 'Ekonomi', 'JAKARTA - YOGYAKARTA', '300000', 'Tidak Tersedia', 1, '300000', '600000', '2019-05-19', 'berhasil'),
('B008', '2019-05-19', 'P002', 'Adi', 'Depok', '08128293746', 'T002', 'Lion Air', 'Eksekutif', 'JAKARTA-BALI', '1900000', 'Tersedia', 1, '1900000', '2200000', '2019-05-19', 'berhasil'),
('B008', '2019-05-19', 'P002', 'Adi', 'Depok', '08128293746', 'T001', 'Air Asia', 'Ekonomi', 'JAKARTA - YOGYAKARTA', '300000', 'Tidak Tersedia', 1, '300000', '2200000', '2019-05-19', 'berhasil'),
('B009', '2019-05-19', 'P002', 'Adi', 'Depok', '08128293746', 'T001', 'Air Asia', 'Ekonomi', 'JAKARTA - YOGYAKARTA', '300000', 'Tidak Tersedia', 1, '300000', '300000', '2019-05-19', 'berhasil'),
('B0010', '2019-05-19', 'P002', 'Adi', 'Depok', '08128293746', 'T001', 'Air Asia', 'Ekonomi', 'JAKARTA - YOGYAKARTA', '300000', 'Tidak Tersedia', 1, '300000', '300000', '2019-05-19', 'berhasil'),
('B0011', '2019-05-19', 'P001', 'Aldhi Ramdan', 'Bekasi', '081283913671', 'T002', 'Lion Air', 'Eksekutif', 'JAKARTA-BALI', '1900000', 'Tersedia', 1, '1900000', '1900000', '2019-05-19', 'berhasil'),
('B0012', '2019-05-19', 'P001', 'Aldhi Ramdan', 'Bekasi', '081283913671', 'T001', 'Air Asia', 'Ekonomi', 'JAKARTA - YOGYAKARTA', '300000', 'Tidak Tersedia', 1, '300000', '300000', '2019-05-19', 'berhasil'),
('B0013', '2019-05-19', 'P001', 'Aldhi Ramdan', 'Bekasi', '081283913671', 'T002', 'Lion Air', 'Eksekutif', 'JAKARTA-BALI', '1900000', 'Tersedia', 1, '1900000', '1900000', '2019-05-19', 'berhasil'),
('B0014', '2019-05-19', 'P001', 'Aldhi Ramdan', 'Bekasi', '081283913671', 'T002', 'Lion Air', 'Eksekutif', 'JAKARTA-BALI', '1900000', 'Tersedia', 1, '1900000', '1900000', '2019-05-19', 'berhasil'),
('B0015', '2019-05-19', 'P001', 'Aldhi Ramdan', 'Bekasi', '081283913671', 'T002', 'Lion Air', 'Eksekutif', 'JAKARTA-BALI', '1900000', 'Tersedia', 1, '1900000', '1900000', '2019-05-19', 'berhasil'),
('B0016', '2019-05-19', 'P001', 'Aldhi Ramdan', 'Bekasi', '081283913671', 'T002', 'Lion Air', 'Eksekutif', 'JAKARTA-BALI', '1900000', 'Tersedia', 1, '1900000', '1900000', '2019-05-19', 'berhasil'),
('B0017', '2019-05-19', 'P001', 'Aldhi Ramdan', 'Bekasi', '081283913671', 'T002', 'Lion Air', 'Eksekutif', 'JAKARTA-BALI', '1900000', 'Tersedia', 1, '1900000', '1900000', '2019-05-19', 'berhasil'),
('B0018', '2019-07-21', 'P001', 'Aldhi Ramdan', 'Bekasi', '081283913671', 'T002', 'Lion Air', 'Eksekutif', 'JAKARTA-BALI', '1900000', 'Tersedia', 1, '1900000', '1900000', '2019-07-21', 'berhasil');

-- --------------------------------------------------------

--
-- Table structure for table `tiket`
--

CREATE TABLE `tiket` (
  `tiket_id` varchar(30) NOT NULL,
  `maskapai_name` varchar(30) NOT NULL,
  `maskapai_class` varchar(20) NOT NULL,
  `destination` varchar(40) NOT NULL,
  `price` decimal(20,0) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tiket`
--

INSERT INTO `tiket` (`tiket_id`, `maskapai_name`, `maskapai_class`, `destination`, `price`, `status`) VALUES
('T001', 'Air Asia', 'Ekonomi', 'JAKARTA - YOGYAKARTA', '300000', 'Tidak Tersedia'),
('T002', 'Lion Air', 'Eksekutif', 'JAKARTA-BALI', '1900000', 'Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `name`) VALUES
('U001', 'admin', 'admin', 'administrator');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tiket`
--
ALTER TABLE `tiket`
  ADD PRIMARY KEY (`tiket_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
