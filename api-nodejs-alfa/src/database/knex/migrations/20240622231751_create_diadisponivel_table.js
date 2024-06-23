/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
    return knex.schema.createTable('diadisponivel', function(table) {
        table.increments('id').primary();
        table.integer('idAgenteSaude').notNullable().unsigned();
        table.date('data').notNullable();
        table.boolean('periodoManha').notNullable();
        table.boolean('periodoTarde').notNullable();
        table.integer('quantVisita').notNullable();
    
        table.foreign('idAgenteSaude').references('agentesaude.id');
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  
};
