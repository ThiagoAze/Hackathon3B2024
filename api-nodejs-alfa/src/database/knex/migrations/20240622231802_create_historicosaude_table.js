/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
  //Criar a tabela historicosaude
    return knex.schema.createTable('historicosaude', function(table) {
        table.increments('id').primary();
        table.boolean('problemaSaude').notNullable();
        table.boolean('alergia').notNullable();
        table.timestamps(true, true).defaultTo(knex.fn.now());
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  return knex.schema.dropTableIfExists('historicosaude');
};
