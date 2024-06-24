/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
  //Criar a tabela diadisponivel
    return knex.schema.createTable('diadisponivel', function(table) {
        table.increments('id').primary();
        table.date('data').notNullable();
        table.boolean('periodoManha').notNullable();
        table.boolean('periodoTarde').notNullable();
        table.integer('quantVisita').notNullable();
        table.timestamp('created_At').defaultTo(knex.fn.now());
        table.timestamp('updated_At').defaultTo(knex.fn.now());
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  return knex.schema.table('diadisponivel', function(table) {
    table.dropColumn('id');
    table.dropColumn('data');
    table.dropColumn('periodoManha');
    table.dropColumn('periodoTarde');
    table.dropColumn('quantVisita');
  });
};
