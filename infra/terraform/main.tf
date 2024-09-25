module "helm_deploy" {
  source                = "./modules/helm"
  helm_service_template = var.helm_service_template
  ecr_repository_url    = "" /*data.aws_ecr_repository.image_tag[var.helm_service_template.name].repository_url*/
  container_image_tag   = "" /*data.aws_ecr_repository.image_tag.most_recent_image_tags[0]*/
  container_image_url   = "" /*data.aws_ecr_repository.repository_url*/
  ingress_config_host   = "teste.com"
}

