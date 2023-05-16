$(document).ready(function(){
    $('#eventTable').DataTable({
        pageLength:50,
        order: [[0, 'desc']]
    });
})