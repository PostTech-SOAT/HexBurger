# data "aws_ecr_repository" "image_tag" {
#   name = var.application
# }

# data "kubernetes_service" "ingress_nginx" {
#   metadata {
#     name      = var.ingress_nginx_name
#     namespace = "kube-system"
#   }
# }
