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
        table.timestamps(true, true).defaultTo(knex.fn.now());
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  return knex.schema.dropTableIfExists('diadisponivel');
};
