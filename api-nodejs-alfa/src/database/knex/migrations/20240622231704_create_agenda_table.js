/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
  //Criar a tabela agenda
    return knex.schema.createTable('agenda', function(table) {
        table.increments('id').primary();;
        table.date('data').notNullable();
        table.time('horario').nullable();
        table.string('rua', 100).notNullable();
        table.string('cep', 8).notNullable();
        table.integer('numero').notNullable();
        table.string('complemento', 100).notNullable();
        table.string('cidade', 100).notNullable();
        table.string('estado', 100).notNullable();
        table.boolean('statusAgendamento').notNullable();
        table.string('periodo', 11).notNullable();
        table.boolean('statusVisita').notNullable();
        table.timestamps(true, true);
      });
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
  return knex.schema.dropTableIfExists('agenda');
};
