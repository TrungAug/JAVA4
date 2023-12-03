<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="editorEditProductModal" tabindex="-1" aria-labelledby="editorEditProductModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-primary" id="editorEditProductModalLabel">Chỉnh sửa thông tin sản phẩm</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body row d-flex justify-content-center">
                    <form action="">
                        <div class="row mb-4">
                            <div class="col-md-6">
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Product ID</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input"
                                        aria-describedby="inputGroup-sizing-default">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Product Name</span>
                                    <input type="text" class="form-control" aria-label="Sizing example input"
                                        aria-describedby="inputGroup-sizing-default">
                                </div>
                            </div>
                        </div>
                        <div class="row mb-4">
                            <p>Tyre Type:</p>
                            <div class="col-lg-2 col-md-3 col-sm-4 m-2">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                    <label class="form-check-label" for="flexCheckDefault">
                                        Lặp thực thể tyre ở đậy
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="row mb-4">
                            <div class="form-floating">
                                <textarea class="form-control" placeholder="Leave a description here"
                                    id="floatingDescription"></textarea>
                                <label for="floatingDescription">Description</label>
                            </div>
                        </div>
                        <div class="row mb-4">
                            <div class="col-md-4">
                                <div class="input-group mb-3">
                                    <input type="file" class="form-control" id="inputGroupFile01">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="input-group mb-3">
                                    <input type="file" class="form-control" id="inputGroupFile02">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="input-group mb-3">
                                    <input type="file" class="form-control" id="inputGroupFile03">
                                </div>
                            </div>
                            <div class="col text-danger">
                                (*) Choose File Image: Leave empty if no change
                            </div>
                        </div>
                        <div class="row mb-4">
                            <p>Publish:</p>
                            <div class="col-lg-2 col-md-3 col-sm-4 m-2">
                                <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                                    <input type="radio" class="btn-check" name="chkPublish" id="chkActive"
                                        autocomplete="off" checked>
                                    <label class="btn btn-outline-primary" for="chkActive">Active</label>

                                    <input type="radio" class="btn-check" name="chkPublish" id="chkInactive"
                                        autocomplete="off">
                                    <label class="btn btn-outline-primary" for="chkInactive">Inactive</label>
                                </div>
                            </div>

                        </div>
                            
                        <div class="row mt-5 d-flex justify-content-end">
                            <button type="button" class="btn btn-primary">Update</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>