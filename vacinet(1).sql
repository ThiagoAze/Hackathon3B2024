-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 25/06/2024 às 17:19
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `vacinet`
--
CREATE DATABASE IF NOT EXISTS `vacinet` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `vacinet`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `acompanhante`
--

CREATE TABLE `acompanhante` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `telefone` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `idIdoso` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `acompanhante`
--

INSERT INTO `acompanhante` (`id`, `nome`, `cpf`, `telefone`, `email`, `senha`, `created_at`, `updated_at`, `idIdoso`) VALUES
(1, 'Anna Pereira', '31554797527', '21983502223', 'annapereiratr@gmail.com', 'trhth445vda', '2024-06-25 12:05:22', '2024-06-25 12:05:22', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `agenda`
--

CREATE TABLE `agenda` (
  `id` int(10) UNSIGNED NOT NULL,
  `data` date NOT NULL,
  `horario` time DEFAULT NULL,
  `rua` varchar(100) NOT NULL,
  `cep` varchar(8) NOT NULL,
  `numero` int(11) NOT NULL,
  `complemento` varchar(100) NOT NULL,
  `cidade` varchar(100) NOT NULL,
  `estado` varchar(100) NOT NULL,
  `statusAgendamento` tinyint(1) NOT NULL,
  `periodo` varchar(11) NOT NULL,
  `statusVisita` tinyint(1) NOT NULL,
  `created_At` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_At` timestamp NOT NULL DEFAULT current_timestamp(),
  `idAgenteSaude` int(10) UNSIGNED DEFAULT NULL,
  `idIdoso` int(10) UNSIGNED DEFAULT NULL,
  `idVacina` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `agentesaude`
--

CREATE TABLE `agentesaude` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `dataNascimento` date NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `agentesaude`
--

INSERT INTO `agentesaude` (`id`, `nome`, `cpf`, `dataNascimento`, `telefone`, `email`, `senha`, `created_at`, `updated_at`) VALUES
(2, 'Vitor Correia', '35463634232', '1998-07-21', '34987656232', 'vitorcorrea@gmail.com', '57tyr4E3ff1', '2024-06-25 12:28:33', '2024-06-25 12:28:33');

-- --------------------------------------------------------

--
-- Estrutura para tabela `alergia`
--

CREATE TABLE `alergia` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(100) NOT NULL,
  `observacao` varchar(200) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `idIdoso` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `alergia`
--

INSERT INTO `alergia` (`id`, `nome`, `observacao`, `created_at`, `updated_at`, `idIdoso`) VALUES
(1, 'Alergia 1', 'informações sobre alergia', '2024-06-25 12:47:34', '2024-06-25 12:47:34', 1),
(2, 'Alergia 2', 'informações nova alergia', '2024-06-25 12:48:05', '2024-06-25 12:48:05', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `aviso`
--

CREATE TABLE `aviso` (
  `id` int(10) UNSIGNED NOT NULL,
  `enviaAlertaGeral` tinyint(1) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `data` date NOT NULL,
  `hora` time NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `idIdoso` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `aviso`
--

INSERT INTO `aviso` (`id`, `enviaAlertaGeral`, `nome`, `descricao`, `data`, `hora`, `created_at`, `updated_at`, `idIdoso`) VALUES
(1, 1, 'Nova vacina disponível', 'Agende a sua vacinação contra Hepatite B', '2024-06-17', '09:38:00', '2024-06-25 12:39:13', '2024-06-25 12:39:13', 1),
(2, 0, 'Sua vacinação foi confirmada! Confira a Hora', 'Pedido de visita confirmada, para informações sobre o horário confira o app', '2024-06-25', '10:52:42', '2024-06-25 13:52:42', '2024-06-25 13:52:42', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `diadisponivel`
--

CREATE TABLE `diadisponivel` (
  `id` int(10) UNSIGNED NOT NULL,
  `data` date NOT NULL,
  `periodoManha` tinyint(1) NOT NULL,
  `periodoTarde` tinyint(1) NOT NULL,
  `quantVisita` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `idAgenteSaude` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `diadisponivel`
--

INSERT INTO `diadisponivel` (`id`, `data`, `periodoManha`, `periodoTarde`, `quantVisita`, `created_at`, `updated_at`, `idAgenteSaude`) VALUES
(2, '2024-06-29', 1, 0, 5, '2024-06-25 12:42:04', '2024-06-25 12:42:04', 2),
(3, '2024-06-28', 1, 1, 20, '2024-06-25 12:43:03', '2024-06-25 12:43:03', 2),
(4, '2024-06-30', 0, 0, 0, '2024-06-25 12:43:46', '2024-06-25 12:43:46', 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `idoso`
--

CREATE TABLE `idoso` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(100) NOT NULL,
  `cpf` varchar(11) NOT NULL,
  `dataNascimento` date NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL,
  `genero` varchar(2) NOT NULL,
  `acompanhante` tinyint(1) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `idoso`
--

INSERT INTO `idoso` (`id`, `nome`, `cpf`, `dataNascimento`, `telefone`, `email`, `senha`, `genero`, `acompanhante`, `created_at`, `updated_at`) VALUES
(1, 'Vinícius Sousa', '64402639867', '1947-07-24', '44970554615', 'vinisouza@gmail.com', 'aaaaaaaa', 'M', 1, '2024-06-25 12:05:22', '2024-06-25 12:05:22');

-- --------------------------------------------------------

--
-- Estrutura para tabela `knex_migrations`
--

CREATE TABLE `knex_migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `batch` int(11) DEFAULT NULL,
  `migration_time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `knex_migrations`
--

INSERT INTO `knex_migrations` (`id`, `name`, `batch`, `migration_time`) VALUES
(2, '20240622231704_create_agenda_table.js', 1, '2024-06-24 01:38:25'),
(3, '20240622231719_create_agentesaude_table.js', 1, '2024-06-24 01:38:25'),
(4, '20240622231731_create_alergia_table.js', 1, '2024-06-24 01:38:25'),
(5, '20240622231742_create_aviso_table.js', 1, '2024-06-24 01:38:25'),
(6, '20240622231751_create_diadisponivel_table.js', 1, '2024-06-24 01:38:25'),
(7, '20240622231811_create_idoso_table.js', 1, '2024-06-24 01:38:25'),
(8, '20240622231822_create_problemasaude_table.js', 1, '2024-06-24 01:38:25'),
(9, '20240622231833_create_vacina_table.js', 1, '2024-06-24 01:38:25'),
(10, '20240623165001_add_foreign_key_agenda.js', 1, '2024-06-24 01:38:25'),
(11, '20240623171235_add_foreign_key_alergia.js', 1, '2024-06-24 01:38:25'),
(12, '20240623171335_add_foreign_key_aviso.js', 1, '2024-06-24 01:38:25'),
(13, '20240623171420_add_foreign_key_diadisponivel.js', 1, '2024-06-24 01:38:25'),
(14, '20240623171512_add_foreign_key_problemasaude.js', 1, '2024-06-24 01:38:25'),
(15, '20240623180451_create_acompanhante_table.js', 1, '2024-06-24 01:38:25'),
(16, '20240623181845_add_foreign_key_acompanhante.js', 1, '2024-06-24 01:38:25');

-- --------------------------------------------------------

--
-- Estrutura para tabela `knex_migrations_lock`
--

CREATE TABLE `knex_migrations_lock` (
  `index` int(10) UNSIGNED NOT NULL,
  `is_locked` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `knex_migrations_lock`
--

INSERT INTO `knex_migrations_lock` (`index`, `is_locked`) VALUES
(1, 0);

-- --------------------------------------------------------

--
-- Estrutura para tabela `problemasaude`
--

CREATE TABLE `problemasaude` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(100) NOT NULL,
  `observacao` varchar(200) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `idIdoso` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `problemasaude`
--

INSERT INTO `problemasaude` (`id`, `nome`, `observacao`, `created_at`, `updated_at`, `idIdoso`) VALUES
(1, 'Problema de Saude 1', 'descrição Problema de Saude 1', '2024-06-25 12:48:38', '2024-06-25 12:48:38', 1),
(2, 'Problema de Saude 2', 'Descrição Problema de Saude 2', '2024-06-25 12:48:49', '2024-06-25 12:48:49', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `vacina`
--

CREATE TABLE `vacina` (
  `id` int(10) UNSIGNED NOT NULL,
  `nome` varchar(100) NOT NULL,
  `idadeMinima` int(11) NOT NULL,
  `idadeMaxima` int(11) NOT NULL,
  `dataInicio` date NOT NULL,
  `dataFinal` date NOT NULL,
  `doenca` varchar(100) NOT NULL,
  `observacao` varchar(100) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `vacina`
--

INSERT INTO `vacina` (`id`, `nome`, `idadeMinima`, `idadeMaxima`, `dataInicio`, `dataFinal`, `doenca`, `observacao`, `created_at`, `updated_at`) VALUES
(1, 'Vacina Hepatite B (HB - recombinante)', 60, 100, '2024-06-17', '2024-07-25', 'Hepatite B', '(3 doses, de acordo com histórico vacinal)', '2024-06-25 12:37:48', '2024-06-25 12:37:48');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `acompanhante`
--
ALTER TABLE `acompanhante`
  ADD PRIMARY KEY (`id`),
  ADD KEY `acompanhante_ididoso_foreign` (`idIdoso`);

--
-- Índices de tabela `agenda`
--
ALTER TABLE `agenda`
  ADD PRIMARY KEY (`id`),
  ADD KEY `agenda_idagentesaude_foreign` (`idAgenteSaude`),
  ADD KEY `agenda_ididoso_foreign` (`idIdoso`),
  ADD KEY `agenda_idvacina_foreign` (`idVacina`);

--
-- Índices de tabela `agentesaude`
--
ALTER TABLE `agentesaude`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `alergia`
--
ALTER TABLE `alergia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `alergia_ididoso_foreign` (`idIdoso`);

--
-- Índices de tabela `aviso`
--
ALTER TABLE `aviso`
  ADD PRIMARY KEY (`id`),
  ADD KEY `aviso_ididoso_foreign` (`idIdoso`);

--
-- Índices de tabela `diadisponivel`
--
ALTER TABLE `diadisponivel`
  ADD PRIMARY KEY (`id`),
  ADD KEY `diadisponivel_idagentesaude_foreign` (`idAgenteSaude`);

--
-- Índices de tabela `idoso`
--
ALTER TABLE `idoso`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `knex_migrations`
--
ALTER TABLE `knex_migrations`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `knex_migrations_lock`
--
ALTER TABLE `knex_migrations_lock`
  ADD PRIMARY KEY (`index`);

--
-- Índices de tabela `problemasaude`
--
ALTER TABLE `problemasaude`
  ADD PRIMARY KEY (`id`),
  ADD KEY `problemasaude_ididoso_foreign` (`idIdoso`);

--
-- Índices de tabela `vacina`
--
ALTER TABLE `vacina`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `acompanhante`
--
ALTER TABLE `acompanhante`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `agenda`
--
ALTER TABLE `agenda`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `agentesaude`
--
ALTER TABLE `agentesaude`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `alergia`
--
ALTER TABLE `alergia`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `aviso`
--
ALTER TABLE `aviso`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `diadisponivel`
--
ALTER TABLE `diadisponivel`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `idoso`
--
ALTER TABLE `idoso`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `knex_migrations`
--
ALTER TABLE `knex_migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de tabela `knex_migrations_lock`
--
ALTER TABLE `knex_migrations_lock`
  MODIFY `index` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `problemasaude`
--
ALTER TABLE `problemasaude`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `vacina`
--
ALTER TABLE `vacina`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `acompanhante`
--
ALTER TABLE `acompanhante`
  ADD CONSTRAINT `acompanhante_ididoso_foreign` FOREIGN KEY (`idIdoso`) REFERENCES `idoso` (`id`);

--
-- Restrições para tabelas `agenda`
--
ALTER TABLE `agenda`
  ADD CONSTRAINT `agenda_idagentesaude_foreign` FOREIGN KEY (`idAgenteSaude`) REFERENCES `agentesaude` (`id`),
  ADD CONSTRAINT `agenda_ididoso_foreign` FOREIGN KEY (`idIdoso`) REFERENCES `idoso` (`id`),
  ADD CONSTRAINT `agenda_idvacina_foreign` FOREIGN KEY (`idVacina`) REFERENCES `vacina` (`id`);

--
-- Restrições para tabelas `alergia`
--
ALTER TABLE `alergia`
  ADD CONSTRAINT `alergia_ididoso_foreign` FOREIGN KEY (`idIdoso`) REFERENCES `idoso` (`id`);

--
-- Restrições para tabelas `aviso`
--
ALTER TABLE `aviso`
  ADD CONSTRAINT `aviso_ididoso_foreign` FOREIGN KEY (`idIdoso`) REFERENCES `idoso` (`id`);

--
-- Restrições para tabelas `diadisponivel`
--
ALTER TABLE `diadisponivel`
  ADD CONSTRAINT `diadisponivel_idagentesaude_foreign` FOREIGN KEY (`idAgenteSaude`) REFERENCES `agentesaude` (`id`);

--
-- Restrições para tabelas `problemasaude`
--
ALTER TABLE `problemasaude`
  ADD CONSTRAINT `problemasaude_ididoso_foreign` FOREIGN KEY (`idIdoso`) REFERENCES `idoso` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
