-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 08-Set-2016 às 05:38
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `guarubd`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `ra` int(11) NOT NULL,
  `modulo` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `rg` varchar(20) NOT NULL,
  `pagamento` float NOT NULL,
  `desconto` int(11) NOT NULL,
  `dataMatricula` date NOT NULL,
  `parcelas` int(11) NOT NULL DEFAULT '1',
  `requerimento` int(11) NOT NULL DEFAULT '0',
  `ativado` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`ra`, `modulo`, `nome`, `senha`, `rg`, `pagamento`, `desconto`, `dataMatricula`, `parcelas`, `requerimento`, `ativado`) VALUES
(1, 1, 'Leonardo Andrade', 'leonardo.andrade', '132.222.113-2', 200, 0, '2016-01-04', 1, 1, 1),
(2, 1, 'Giovanni Anderson', 'giovanni.anderson', '221.145.897-5', 100, 0, '2016-01-04', 2, 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `aulas`
--

CREATE TABLE `aulas` (
  `id_aluno` int(11) NOT NULL,
  `id_professor` int(11) NOT NULL,
  `id_modulo` int(11) NOT NULL,
  `nota1` varchar(1) DEFAULT NULL,
  `nota2` varchar(1) DEFAULT NULL,
  `notaFinal` varchar(1) DEFAULT NULL,
  `quantidadeAulas` int(11) NOT NULL,
  `faltas` int(11) NOT NULL,
  `frequencia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `aulas`
--

INSERT INTO `aulas` (`id_aluno`, `id_professor`, `id_modulo`, `nota1`, `nota2`, `notaFinal`, `quantidadeAulas`, `faltas`, `frequencia`) VALUES
(1, 1, 1, NULL, NULL, NULL, 0, 0, NULL),
(2, 1, 1, 'A', 'A', 'A', 20, 2, 90);

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `id_curso` int(11) NOT NULL,
  `idioma` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`id_curso`, `idioma`) VALUES
(1, 'Inglês'),
(2, 'Francês'),
(3, 'Português'),
(4, 'Alemão');

-- --------------------------------------------------------

--
-- Estrutura da tabela `modulo`
--

CREATE TABLE `modulo` (
  `id_modulo` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL,
  `nivel` varchar(20) NOT NULL,
  `cargaHoraria` int(11) NOT NULL,
  `preco` float NOT NULL,
  `publico` varchar(20) NOT NULL,
  `semestre` int(11) NOT NULL,
  `ano` int(11) NOT NULL,
  `conteudo` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `modulo`
--

INSERT INTO `modulo` (`id_modulo`, `id_curso`, `nivel`, `cargaHoraria`, `preco`, `publico`, `semestre`, `ano`, `conteudo`) VALUES
(1, 1, 'Básico', 20, 200, 'Infantil', 1, 2016, 'Inicial de Inglês'),
(2, 1, 'Intermediário', 40, 250, 'Infantil', 2, 2016, 'Intermediario de Inglês');

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `id_professor` int(11) NOT NULL,
  `modulo` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `user` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL,
  `cargaHoraria` int(11) NOT NULL,
  `salario` int(11) NOT NULL,
  `especialidade` varchar(75) NOT NULL,
  `ativado` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`id_professor`, `modulo`, `nome`, `user`, `senha`, `cargaHoraria`, `salario`, `especialidade`, `ativado`) VALUES
(1, 1, 'José Antônio', 'jose.antonio', 'professorguaru', 20, 1000, 'Inglês para crianças', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `user` varchar(50) NOT NULL,
  `senha` varchar(50) NOT NULL DEFAULT 'guaru123',
  `cargo` varchar(50) NOT NULL,
  `acesso` varchar(50) NOT NULL,
  `dataSenha` date NOT NULL,
  `primeiroAcesso` int(11) NOT NULL DEFAULT '1',
  `ativado` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `user`, `senha`, `cargo`, `acesso`, `dataSenha`, `primeiroAcesso`, `ativado`) VALUES
(1, 'Maria José', 'maria.jose', 'guaru123', 'Diretora', 'Administrador', '2016-09-07', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`ra`),
  ADD KEY `modulo` (`modulo`),
  ADD KEY `modulo_2` (`modulo`);

--
-- Indexes for table `aulas`
--
ALTER TABLE `aulas`
  ADD KEY `id_aluno` (`id_aluno`,`id_professor`,`id_modulo`),
  ADD KEY `id_professor` (`id_professor`),
  ADD KEY `id_modulo` (`id_modulo`);

--
-- Indexes for table `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id_curso`);

--
-- Indexes for table `modulo`
--
ALTER TABLE `modulo`
  ADD PRIMARY KEY (`id_modulo`),
  ADD KEY `id_curso` (`id_curso`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`id_professor`),
  ADD KEY `modulo` (`modulo`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aluno`
--
ALTER TABLE `aluno`
  MODIFY `ra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `curso`
--
ALTER TABLE `curso`
  MODIFY `id_curso` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `modulo`
--
ALTER TABLE `modulo`
  MODIFY `id_modulo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `professor`
--
ALTER TABLE `professor`
  MODIFY `id_professor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `aluno_ibfk_1` FOREIGN KEY (`modulo`) REFERENCES `modulo` (`id_modulo`);

--
-- Limitadores para a tabela `aulas`
--
ALTER TABLE `aulas`
  ADD CONSTRAINT `aulas_ibfk_1` FOREIGN KEY (`id_aluno`) REFERENCES `aluno` (`ra`),
  ADD CONSTRAINT `aulas_ibfk_2` FOREIGN KEY (`id_professor`) REFERENCES `professor` (`id_professor`),
  ADD CONSTRAINT `aulas_ibfk_3` FOREIGN KEY (`id_modulo`) REFERENCES `modulo` (`id_modulo`);

--
-- Limitadores para a tabela `modulo`
--
ALTER TABLE `modulo`
  ADD CONSTRAINT `modulo_ibfk_1` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`);

--
-- Limitadores para a tabela `professor`
--
ALTER TABLE `professor`
  ADD CONSTRAINT `professor_ibfk_1` FOREIGN KEY (`modulo`) REFERENCES `modulo` (`id_modulo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
