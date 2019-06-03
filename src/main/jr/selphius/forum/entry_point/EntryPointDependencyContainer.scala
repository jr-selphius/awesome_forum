package jr.selphius.forum.entry_point

import jr.selphius.forum.entry_point.controller.community.{
  CommunityDeleteController,
  CommunityGetController,
  CommunityPostController,
  CommunityPutController
}
import jr.selphius.forum.entry_point.controller.user.{
  UserDeleteController,
  UserGetController,
  UserPostController,
  UserPutController
}
import jr.selphius.forum.module.community.infrastructure.dependency_injection.CommunityModuleDependencyContainer
import jr.selphius.forum.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer

final class EntryPointDependencyContainer(userDependencies: UserModuleDependencyContainer,
                                          communityDependencies: CommunityModuleDependencyContainer) {
  val userGetController         = new UserGetController(userDependencies.usersSearcher)
  val userPostController        = new UserPostController(userDependencies.userCreator)
  val userPutController         = new UserPutController(userDependencies.userUpdater)
  val userDeleteController      = new UserDeleteController(userDependencies.userRemover)
  val communityGetController    = new CommunityGetController(communityDependencies.communitiesSearcher)
  val communityPostController   = new CommunityPostController(communityDependencies.communityCreator)
  val communityPutController    = new CommunityPutController(communityDependencies.communityUpdater)
  val communityDeleteController = new CommunityDeleteController(communityDependencies.communityRemover)
}
