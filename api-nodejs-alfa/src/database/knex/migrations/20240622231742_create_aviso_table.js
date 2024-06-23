/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
    return knex.schema.createTable('aviso', function(table) {
        table.increments('id').primary();
        table.integer('idIdoso').notNullable().unsigned();
        table.boolean('enviaAlertaGeral').notNullable();
        table.string('nome', 100).notNullable();
        table.string('descricao', 200).notNullable();
        table.date('data').notNullable();
        table.time('hora').notNullable();
    
        table.foreign('idIdoso').references('idoso.id');
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  
};
