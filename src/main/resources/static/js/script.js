function getCard() {
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