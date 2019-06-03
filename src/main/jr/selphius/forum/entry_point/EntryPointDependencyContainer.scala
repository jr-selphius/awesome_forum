package jr.selphius.forum.entry_point

import jr.selphius.forum.entry_point.controller.community.{
  CommunityGetController,
  CommunityPostController,
  CommunityPutController
}
import jr.selphius.forum.entry_point.controller.user.{UserGetController, UserPostController, UserPutController}
import jr.selphius.forum.module.community.infrastructure.dependency_injection.CommunityModuleDependencyContainer
import jr.selphius.forum.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer

final class EntryPointDependencyContainer(userDependencies: UserModuleDependencyContainer,
                                          communityDependencies: CommunityModuleDependencyContainer) {
  val userGetController       = new UserGetController(userDependencies.usersSearcher)
  val userPostController      = new UserPostController(userDependencies.userCreator)
  val userPutController       = new UserPutController(userDependencies.userUpdater)
  val communityGetController  = new CommunityGetController(communityDependencies.communitiesSearcher)
  val communityPostController = new CommunityPostController(communityDependencies.communitiesCreator)
  val communityPutController  = new CommunityPutController(communityDependencies.communitiesUpdater)
}
