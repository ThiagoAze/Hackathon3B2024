/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
  //Criar a tabela acompanhante
    return knex.schema.createTable('acompanhante', function(table) {
        table.increments('id').primary();
        table.string('nome', 100).notNullable();
        table.string('cpf', 11).notNullable();
        table.string('telefone', 100).notNullable();
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
  return knex.schema.table('acompanhante', function(table) {
    table.dropColumn('id');
    table.dropColumn('nome');
    table.dropColumn('cpf');
    table.dropColumn('telefone');
    table.dropColumn('email');
    table.dropColumn('senha');
  });
};
