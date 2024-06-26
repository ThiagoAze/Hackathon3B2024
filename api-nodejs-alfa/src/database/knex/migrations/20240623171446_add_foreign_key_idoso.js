/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
  //Chave estrangeira da tabela idoso
  return knex.schema.table('idoso', function (table) {
      //campo idHistoricoSaude

    table.integer('idHistoricoSaude').unsigned();
    table.foreign('idHistoricoSaude').references('id').inTable('historicosaude');
});
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
   //reverter dados modificados
   return knex.schema.table('idoso', function(table) {

    //reverter idHistoricoSaude
    table.dropForeign('idHistoricoSaude');
    table.dropColumn('idHistoricoSaude');
  });
  
};
