<#if tableInfo?exists>
<div class="modal fade" id="${tableInfo.classLowercaseName}Modal" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="${tableInfo.classLowercaseName}ModalLabel">{{modalName}}</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <!--<div class="row">
                        <div class="form-group col-md-6">
                            <label><span style="color: red">*</span>xx：</label>
                            <input type="text" class="form-control" aria-describedby="emailHelp" v-model="" autocomplete="off">
                        </div>
                        <div class="form-group col-md-6">
                            <label><span style="color: red">*</span>xx：</label>
                            <input type="text" class="form-control" aria-describedby="emailHelp" v-model="" autocomplete="off">
                        </div>
                    </div>-->
                    <#list tableInfo.columns as column>
                        <div class="form-group">
                            <label><span style="color: red">*</span>${column.columnComment}：</label>
                            <input type="text" class="form-control" v-model="${tableInfo.classLowercaseName}.${column.attrLowercaseName}" autocomplete="off">
                        </div>
                    </#list>
                </form>
            </div>
            <div class="modal-footer">
                <!-- flex:1;将标签占满剩下的区域 -->
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" @click="save${tableInfo.classUppercaseName}()">确认</button>
            </div>
        </div>
    </div>
</div>
</#if>