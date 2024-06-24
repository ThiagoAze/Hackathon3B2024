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
        table.timestamp('created_At').defaultTo(knex.fn.now());
        table.timestamp('updated_At').defaultTo(knex.fn.now());
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  return knex.schema.table('vacina', function(table) {
    table.dropColumn('id');
    table.dropColumn('nome');
    table.dropColumn('idadeMinima');
    table.dropColumn('idadeMaxima');
    table.dropColumn('dataInicio');
    table.dropColumn('dataFinal');
    table.dropColumn('doenca');
    table.dropColumn('observacao');
  });
};
