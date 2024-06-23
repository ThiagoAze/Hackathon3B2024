/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
    return knex.schema.createTable('idoso', function(table) {
        table.increments('id').primary();
        table.integer('idHistoricoSaude').notNullable().unsigned();
        table.string('nome', 100).notNullable();
        table.string('cpf', 11).notNullable();
        table.date('dataNascimento').notNullable();
        table.string('telefone', 11).notNullable();
        table.string('email', 100).notNullable();
        table.string('senha', 100).notNullable();
        table.string('genero', 2).notNullable();
        table.integer('idAcompanhante').unsigned();
    
        table.foreign('idHistoricoSaude').references('historicosaude.id');
        table.foreign('idAcompanhante').references('acompanhante.id');
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  
};
