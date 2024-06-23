/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
  //Criar a tabela aviso
    return knex.schema.createTable('aviso', function(table) {
        table.increments('id').primary();
        table.boolean('enviaAlertaGeral').notNullable();
        table.string('nome', 100).notNullable();
        table.string('descricao', 200).notNullable();
        table.date('data').notNullable();
        table.time('hora').notNullable();
        table.timestamps(true, true);
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  return knex.schema.dropTableIfExists('aviso');
  
};
