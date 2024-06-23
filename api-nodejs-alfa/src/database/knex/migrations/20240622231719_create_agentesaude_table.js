/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
  //Criar a tabela agentesaude
    return knex.schema.createTable('agentesaude', function(table) {
        table.increments('id').primary();
        table.string('nome', 100).notNullable();
        table.string('cpf', 11).notNullable();
        table.date('dataNascimento').notNullable();
        table.string('telefone', 11).notNullable();
        table.string('email', 100).notNullable();
        table.string('senha', 100).notNullable();
        table.timestamps(true, true);
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  return knex.schema.dropTableIfExists('agentesaude');
};
