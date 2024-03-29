function getShuffledCard() {
        var data = [];

        $("#shuffledCardTable tr").each(function(){
                var rowData = [];

                $(this).find("td").each(function(){
                        rowData.push($(this).text());
                });

                data.push(rowData);
        });

        distributeCard(data);
}

function getPlayerCard() {
        var data = [];

        $("#playerCardTable tr").each(function(){
                var rowData = [];

                $(this).find("td").each(function(){
                        rowData.push($(this).text());
                });

                data.push(rowData);
        });

        findWinner(data);

}