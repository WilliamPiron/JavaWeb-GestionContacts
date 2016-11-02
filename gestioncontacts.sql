-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mer 02 Novembre 2016 à 20:02
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestioncontacts`
--

-- --------------------------------------------------------

--
-- Structure de la table `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `street` varchar(200) NOT NULL,
  `city` varchar(200) NOT NULL,
  `zip` varchar(25) NOT NULL,
  `country` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `address`
--

INSERT INTO `address` (`id`, `street`, `city`, `zip`, `country`) VALUES
(3, 'oip', 'ville', '92000', 'pays');

-- --------------------------------------------------------

--
-- Structure de la table `contact`
--

CREATE TABLE `contact` (
  `id` int(11) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `contact`
--

INSERT INTO `contact` (`id`, `lastname`, `firstname`, `email`) VALUES
(3, 'pup', 'poi', 'poi@poi.fr'),
(2, 'iopgiyu', 'fyilf', 'ilfy@free.fr'),
(1, 'Zouz', 'Jimmy', 'billy.zouz@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `contactgroup`
--

CREATE TABLE `contactgroup` (
  `groupId` int(11) NOT NULL,
  `groupName` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `contactgroup`
--

INSERT INTO `contactgroup` (`groupId`, `groupName`) VALUES
(1, 'PHP');

-- --------------------------------------------------------

--
-- Structure de la table `groupcomposition`
--

CREATE TABLE `groupcomposition` (
  `idcontact` int(11) NOT NULL,
  `idgroup` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `groupcomposition`
--

INSERT INTO `groupcomposition` (`idcontact`, `idgroup`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `phonenumber`
--

CREATE TABLE `phonenumber` (
  `id` int(11) NOT NULL,
  `idContact` int(11) NOT NULL,
  `phoneKind` varchar(100) NOT NULL,
  `phoneNumber` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `phonenumber`
--

INSERT INTO `phonenumber` (`id`, `idContact`, `phoneKind`, `phoneNumber`) VALUES
(20, 1, 'ghilfy', '405237'),
(26, 3, 'gjkilg', '045345'),
(33, 3, 'hjuilgu', '0746746'),
(37, 2, 'ghilg', '0453274'),
(38, 2, 'cguck', '0453'),
(39, 1, 'hiufv', '078567');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `contactgroup`
--
ALTER TABLE `contactgroup`
  ADD PRIMARY KEY (`groupId`,`groupName`);

--
-- Index pour la table `groupcomposition`
--
ALTER TABLE `groupcomposition`
  ADD PRIMARY KEY (`idcontact`,`idgroup`);

--
-- Index pour la table `phonenumber`
--
ALTER TABLE `phonenumber`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `phonenumber`
--
ALTER TABLE `phonenumber`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
