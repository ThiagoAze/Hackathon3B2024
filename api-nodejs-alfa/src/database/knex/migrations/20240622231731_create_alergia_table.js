/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
    return knex.schema.createTable('alergia', function(table) {
        table.increments('id').primary();
        table.string('nome', 100).notNullable();
        table.string('observacao', 200).notNullable();
        table.integer('idHistoricoSaude').notNullable().unsigned();
    
        table.foreign('idHistoricoSaude').references('historicosaude.id');
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  
};
