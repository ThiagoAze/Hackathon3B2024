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
        table.timestamp('created_At').defaultTo(knex.fn.now());
        table.timestamp('updated_At').defaultTo(knex.fn.now());
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  return knex.schema.table('agentesaude', function(table) {
    table.dropColumn('id');
    table.dropColumn('nome');
    table.dropColumn('cpf');
    table.dropColumn('dataNascimento');
    table.dropColumn('telefone');
    table.dropColumn('email');
    table.dropColumn('senha');
  });
};
