data <- read.table("/Users/yetingzhang/Desktop/GSE118900_MM.scrna-seq.tpm.pass.txt", header = TRUE, 
+ row.names = 1,
+ check.names = F,
+ sep = "\t")

> myproject <- CreateSeuratObject(counts = data)
> myproject <- PercentageFeatureSet(myproject, pattern = "^MT-", col.name = "percent.mt")
> myproject <- SCTransform(myproject, vars.to.regress = "percent.mt", verbose = FALSE)

Error

************use seurat2 procedure*******************
library(dplyr)
myproject <- NormalizeData(myproject)
myproject <- FindVariableFeatures(myproject)
all.genes <- rownames(myproject)
myproject <- ScaleData(myproject, features = all.genes)
myproject <- RunPCA (myproject)
DimPlot(myproject, reduction = "pca")
ElbowPlot(myproject)
myproject <- FindNeighbors(myproject, dims = 1:20)
myproject <- FindClusters(myproject, resolution = 0.5)
myproject < -RunTSNE(myproject, dims = 1:20)
DimPlot(myproject, reduction = "tsne")
myproject.markers <- FindAllMarkers(myproject, only.pos = TRUE, min.pct = 0.25, logfc.threshold = 0.25)
myproject.markers %>% group_by(cluster) %>% top_n(n = 2, wt = avg_logFC)


> FeaturePlot(myproject, features = c("ATF6-chr1-161736034"))
> VlnPlot(myproject, features = "ATF6-chr1-161736034")
> VlnPlot(myproject, features = "ATF6-chr1-161736034", pt = 0.5)
> VlnPlot(myproject, features = "ATF6-chr1-161736034", pt = 0)
> VlnPlot(myproject, features = c("ATF6-chr1-161736034", "EIF2A-chr3-150264574"), pt = 0)
> VlnPlot(myproject, features = c("ATF6-chr1-161736034", "EIF2A-chr3-150264574", "ERLEC1-chr2-54014068"), pt = 0)
> VlnPlot(myproject, features = c("SDC1-chr2-20400558"), pt = 0)
> FeaturePlot(myproject, features = c("SDC1-chr2-20400558"))
> VlnPlot(myproject, features = c("SDC1-chr2-20400558"), pt = 0)
VlnPlot(myproject, features = c("PSMB10-chr16-67968407"), pt = 0)



> FeaturePlot(myproject, features = c("PTGS2-chr1-186640944"))
> VlnPlot(myproject, features = c("PTGS2-chr1-186640944"), pt = 0)
> VlnPlot(myproject, features = c("PSMA4-chr15-78832747"), pt = 0)
> VlnPlot(myproject, features = c("PTPRC-chr1-198608137"), pt = 0)
> FeaturePlot(myproject, features = c("PTPRC-chr1-198608137"))
> VlnPlot(myproject, features = c("PTPRC-chr1-198608137", "FOXP3-chrX-49106897"), pt = 0)
> VlnPlot(myproject, features = c("PTPRC-chr1-198608137", "FOXP3-chrX-49106897","CD8A-chr2-87011728"), pt = 0)
> VlnPlot(myproject, features = c("PTPRC-chr1-198608137", "FOXP3-chrX-49106897","CD8A-chr2-87011728", "CD4-chr12-6898638"), pt = 0)


