/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
  //Criar a tabela alergia
    return knex.schema.createTable('alergia', function(table) {
        table.increments('id').primary();
        table.string('nome', 100).notNullable();
        table.string('observacao', 200).notNullable();
        table.timestamp('created_At').defaultTo(knex.fn.now());
        table.timestamp('updated_At').defaultTo(knex.fn.now());
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  return knex.schema.table('alergia', function(table) {
    table.dropColumn('id');
    table.dropColumn('nome');
    table.dropColumn('observacao');
  });
};
