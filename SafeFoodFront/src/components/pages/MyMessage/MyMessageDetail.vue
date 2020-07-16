<template>
    <div class="container-fluid">
    <table class="table">
      <thead>
        <tr>
          <th style="width:60%;">Title</th>
          <th>보낸이</th>
          <th>받는이</th>
          <th>Written date</th>
        </tr>
      </thead>
      <tbody>
        <tr >
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td colspan="4">
            <textarea id="contents" class="form-control" rows="5"  cols="1000"  readonly="true" ></textarea>
          </td>
        </tr>
      </tbody>
    </table>
    <div align="right" style="margin-bottom:10px;" >
      <button type="button" class="btn btn-danger" id="deleteBtn" >삭제</button>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>