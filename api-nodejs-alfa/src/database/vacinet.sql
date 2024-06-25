-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 23/06/2024 às 21:04
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

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
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
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
  `idHistoricoSaude` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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

-- --------------------------------------------------------

--
-- Estrutura para tabela `historicosaude`
--

CREATE TABLE `historicosaude` (
  `id` int(10) UNSIGNED NOT NULL,
  `problemaSaude` tinyint(1) NOT NULL,
  `alergia` tinyint(1) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `idHistoricoSaude` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
(1, '20240622231704_create_agenda_table.js', 1, '2024-06-23 18:48:59'),
(2, '20240622231719_create_agentesaude_table.js', 1, '2024-06-23 18:48:59'),
(3, '20240622231731_create_alergia_table.js', 1, '2024-06-23 18:48:59'),
(4, '20240622231742_create_aviso_table.js', 1, '2024-06-23 18:48:59'),
(5, '20240622231751_create_diadisponivel_table.js', 1, '2024-06-23 18:48:59'),
(6, '20240622231802_create_historicosaude_table.js', 1, '2024-06-23 18:48:59'),
(7, '20240622231811_create_idoso_table.js', 1, '2024-06-23 18:48:59'),
(8, '20240622231822_create_problemasaude_table.js', 1, '2024-06-23 18:48:59'),
(9, '20240622231833_create_vacina_table.js', 1, '2024-06-23 18:48:59'),
(10, '20240623165001_add_foreign_key_agenda.js', 1, '2024-06-23 18:49:00'),
(11, '20240623171235_add_foreign_key_alergia.js', 1, '2024-06-23 18:49:00'),
(12, '20240623171335_add_foreign_key_aviso.js', 1, '2024-06-23 18:49:00'),
(13, '20240623171420_add_foreign_key_diadisponivel.js', 1, '2024-06-23 18:49:00'),
(14, '20240623171446_add_foreign_key_idoso.js', 1, '2024-06-23 18:49:00'),
(15, '20240623171512_add_foreign_key_problemasaude.js', 1, '2024-06-23 18:49:00'),
(16, '20240623180451_create_acompanhante_table.js', 1, '2024-06-23 18:49:00'),
(17, '20240623181845_add_foreign_key_acompanhante.js', 1, '2024-06-23 18:49:00');

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
  `idProblemaSaude` int(10) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  ADD KEY `alergia_idhistoricosaude_foreign` (`idHistoricoSaude`);

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
-- Índices de tabela `historicosaude`
--
ALTER TABLE `historicosaude`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `idoso`
--
ALTER TABLE `idoso`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idoso_idhistoricosaude_foreign` (`idHistoricoSaude`);

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
  ADD KEY `problemasaude_idproblemasaude_foreign` (`idProblemaSaude`);

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
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `agenda`
--
ALTER TABLE `agenda`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `agentesaude`
--
ALTER TABLE `agentesaude`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `alergia`
--
ALTER TABLE `alergia`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `aviso`
--
ALTER TABLE `aviso`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `diadisponivel`
--
ALTER TABLE `diadisponivel`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `historicosaude`
--
ALTER TABLE `historicosaude`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `idoso`
--
ALTER TABLE `idoso`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `knex_migrations`
--
ALTER TABLE `knex_migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de tabela `knex_migrations_lock`
--
ALTER TABLE `knex_migrations_lock`
  MODIFY `index` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `problemasaude`
--
ALTER TABLE `problemasaude`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `vacina`
--
ALTER TABLE `vacina`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `alergia_idhistoricosaude_foreign` FOREIGN KEY (`idHistoricoSaude`) REFERENCES `historicosaude` (`id`);

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
-- Restrições para tabelas `idoso`
--
ALTER TABLE `idoso`
  ADD CONSTRAINT `idoso_idhistoricosaude_foreign` FOREIGN KEY (`idHistoricoSaude`) REFERENCES `historicosaude` (`id`);

--
-- Restrições para tabelas `problemasaude`
--
ALTER TABLE `problemasaude`
  ADD CONSTRAINT `problemasaude_idproblemasaude_foreign` FOREIGN KEY (`idProblemaSaude`) REFERENCES `problemasaude` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
