-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Waktu pembuatan: 15 Jul 2023 pada 10.27
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `kd_brg` varchar(6) NOT NULL,
  `nm_brg` varchar(30) DEFAULT NULL,
  `satuan` varchar(10) NOT NULL,
  `harga` double NOT NULL,
  `harga_beli` double NOT NULL,
  `stok` int(5) NOT NULL,
  `stok_min` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`kd_brg`, `nm_brg`, `satuan`, `harga`, `harga_beli`, `stok`, `stok_min`) VALUES
('00001', 'Durian', 'Kg', 50000, 45000, 20, 3),
('00002', 'Buku', 'Buah', 2000, 1000, 10, 3),
('00003', 'Minyak', 'Liter', 15000, 10000, 15, 2),
('00004', 'Telur', 'Kg', 22000, 20000, 50, 10),
('00005', 'Pensil', 'Buah', 15000, 10000, 18, 12),
('00006', 'Susu', 'Liter', 10000, 8000, 10, 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `djual`
--

CREATE TABLE `djual` (
  `no_jual` varchar(10) NOT NULL,
  `kd_brg` char(6) NOT NULL,
  `harga_jual` float NOT NULL,
  `jml_jual` int(4) NOT NULL,
  `diskon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `djual`
--

INSERT INTO `djual` (`no_jual`, `kd_brg`, `harga_jual`, `jml_jual`, `diskon`) VALUES
('2', '00001', 50000, 3, 5),
('3', '00001', 50000, 2, 5000),
('4', '00003', 15000, 2, 1500),
('5', '00005', 15000, 5, 3000),
('6', '00002', 2000, 5, 400),
('7', '00006', 10000, 5, 1000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `jual`
--

CREATE TABLE `jual` (
  `no_jual` varchar(10) NOT NULL,
  `kd_kons` char(6) NOT NULL,
  `tgl_jual` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `jual`
--

INSERT INTO `jual` (`no_jual`, `kd_kons`, `tgl_jual`) VALUES
('1', 'VIP001', '2023-06-19'),
('2', 'VIP001', '2023-07-04'),
('3', 'U1B73K', '2023-07-07'),
('4', 'B8UKI1', '2023-07-09'),
('5', 'BJ7L0A', '2023-07-09'),
('6', 'B8UKI1', '2023-07-11'),
('7', 'RL9V24', '2023-07-15');

-- --------------------------------------------------------

--
-- Struktur dari tabel `konsumen`
--

CREATE TABLE `konsumen` (
  `kd_kons` varchar(6) NOT NULL,
  `nm_kons` varchar(30) NOT NULL,
  `alm_kons` varchar(50) NOT NULL,
  `kota_kons` varchar(20) NOT NULL,
  `kd_pos` varchar(5) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `konsumen`
--

INSERT INTO `konsumen` (`kd_kons`, `nm_kons`, `alm_kons`, `kota_kons`, `kd_pos`, `phone`, `email`) VALUES
('B8UKI1', 'Nana', 'Jalan Bima', 'Semarang', '5645', '08982614278', 'nana@gmail.com'),
('BJ7L0A', 'Kaka', 'Jalan Raya', 'Malang', '7899', '081234567890', 'kaka@gmail.com'),
('REG001', 'Joko Susilo', 'Jalan Pelan Banyak Anak', 'Jombang', '1234', '0812345678', 'joko@gmail.com'),
('RL9V24', 'Budi', 'Jalan Nakula', 'Solo', '2591', '089523146781', 'budi@gmail.com'),
('VIP001', 'R. Danny Oka', 'Jalan-jalan Yuk!', 'Semarang', '5758', '0851234567', 'danny@dinus.ac.id');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `role` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id`, `username`, `nama`, `role`, `password`) VALUES
(1, 'Danny', 'R. Danny Oka', 'admin', 'c44a471bd78cc6c2fea32b9fe028d30a'),
(2, 'Oka', 'Mas Oka', 'user', '02c75fb22c75b23dc963c7eb91a062cc');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kd_brg`);

--
-- Indeks untuk tabel `jual`
--
ALTER TABLE `jual`
  ADD PRIMARY KEY (`no_jual`);

--
-- Indeks untuk tabel `konsumen`
--
ALTER TABLE `konsumen`
  ADD PRIMARY KEY (`kd_kons`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
