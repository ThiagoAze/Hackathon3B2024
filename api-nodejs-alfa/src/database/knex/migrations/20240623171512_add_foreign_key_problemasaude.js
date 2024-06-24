/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
   //Chave estrangeira da tabela problemasaude
   return knex.schema.table('problemasaude', function (table) {
    //campo idProblemaSaude

    table.integer('idIdoso').unsigned();
    table.foreign('idIdoso').references('id').inTable('idoso');
});
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
     //reverter dados modificados
     return knex.schema.table('problemasaude', function(table) {

        //reverter idHistoricoSaude
        table.dropForeign('idProblemaSaude');
        table.dropColumn('idProblemaSaude');
      });
  
};
