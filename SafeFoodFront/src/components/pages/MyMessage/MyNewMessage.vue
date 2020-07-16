<template>
<div class="container-fluid">
    <form>
        <label for="NameText">받는이:</label>
      <input id="NameText" class="form-control" type="text" />
      <br />
      <label for="titleText">제목:</label>
      <input id="titleText" class="form-control" type="text" />
      <br />
      <label for="contents">내용:</label>
      <textarea id="contents" class="form-control" rows="5" cols="1000"></textarea>
      <br />
      <div align="center">
        <button type="button" class="btn btn-primary">보내기</button>
      </div>
    </form>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
label{
  float: left;
}
</style>