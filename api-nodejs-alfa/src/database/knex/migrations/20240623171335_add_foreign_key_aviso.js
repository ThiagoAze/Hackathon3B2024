/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
     //Chave estrangeira da tabela aviso
     return knex.schema.table('aviso', function (table) {
         //campo idIdoso
        
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
     return knex.schema.table('aviso', function(table) {

        //reverter idIdoso
        table.dropForeign('idIdoso');
        table.dropColumn('idIdoso');
      });
  
};
