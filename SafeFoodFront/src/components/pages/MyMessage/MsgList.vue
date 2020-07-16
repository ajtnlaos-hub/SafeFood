<template>
<div class="container-fluid">
    <table class="table table-hover table-condensed" id="list-table" style="margin-top:20px; width:100%;">
      <thead>
        <tr>
          <th class="col-sd-1">check</th>
          <th class="col-sd-2">보낸이</th>
          <th class="col-sd-7">제목</th>
          <th class="col-sd-3">보낸일시</th>
        </tr>
      </thead>
      <tbody>
        <tr >
          <td class="col-sd-1">
              <input type="checkbox" id="delete">
          </td>
          <td class="col-sd-2"></td>
          <td class="col-sd-7"></td>
          <td class="col-sd-3"></td>
        </tr>
      </tbody>
    </table>
    <div style="float:right">
    <input type="button" class="btn btn-outline-primary" value="삭제">
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>