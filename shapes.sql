-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 24 okt 2020 om 20:05
-- Serverversie: 10.4.14-MariaDB
-- PHP-versie: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vat`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `shapes`
--

CREATE TABLE `shapes` (
  `type` enum('CUBE','CYLINDER','PYRAMID','SPHERE','CONE') NOT NULL,
  `length` double DEFAULT NULL,
  `width` double DEFAULT NULL,
  `height` double DEFAULT NULL,
  `radius` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Gegevens worden geëxporteerd voor tabel `shapes`
--

INSERT INTO `shapes` (`type`, `length`, `width`, `height`, `radius`) VALUES
('CUBE', 7, 7, 7, NULL),
('CONE', NULL, NULL, 5, 5),
('CUBE', 6, 6, 6, NULL),
('CYLINDER', NULL, NULL, 8, 8),
('SPHERE', NULL, NULL, NULL, 9),
('PYRAMID', 10, 10, 10, NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
