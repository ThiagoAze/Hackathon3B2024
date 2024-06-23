/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
  //Criar a tabela problemasaude
    return knex.schema.createTable('problemasaude', function(table) {
        table.increments('id').primary();
        table.string('nome', 100).notNullable();
        table.string('observacao', 200).notNullable();
        table.timestamps(true, true);
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  return knex.schema.dropTableIfExists('problemasaude');
};
