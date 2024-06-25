/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.up = function(knex) {
    //chave estrangeira da tabela acompanhante
    return knex.schema.table('acompanhante', function (table) {
        //campo idIdoso
        table.integer('idIdoso').unsigned();
        table.foreign('idIdoso').references('id').inTable('idoso')
    })
  
};

/**
 * @param { import("knex").Knex } knex
 * @returns { Promise<void> }
 */
exports.down = function(knex) {
   //reverter dados modificados
   return knex.schema.table('acompanhante', function(table) {

    //reverter idIdoso
    table.dropForeign('idIdoso');
    table.dropColumn('idIdoso');
  });
};
