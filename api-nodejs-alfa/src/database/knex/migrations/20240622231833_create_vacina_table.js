/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
  //Criar a tabela vacina
    return knex.schema.createTable('vacina', function(table) {
        table.increments('id').primary();
        table.string('nome', 100).notNullable();
        table.integer('idadeMinima').notNullable();
        table.integer('idadeMaxima').notNullable();
        table.date('dataInicio').notNullable();
        table.date('dataFinal').notNullable();
        table.string('doenca', 100).notNullable();
        table.string('observacao', 100).notNullable();
        table.timestamps(true, true);
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  return knex.schema.dropTableIfExists('vacina');
};
